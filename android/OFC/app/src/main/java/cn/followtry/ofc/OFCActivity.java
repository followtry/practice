package cn.followtry.ofc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OFCActivity extends Activity {

    private EditText bikeCode;

    private EditText bikePwd;

    private Button btnWrite;
    private Button btnRead;
    private Button btnReadAll;
    private Button btnImport;
    private Button btn_export;

    private EditText bikeResult;

    private OFCService ofcService;

    private static final String FILE_NAME = "ofc.csv";

    private static final Integer FILE_READ = 10;

    private static final Integer FILE_WRITE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofc);
        bikeCode = (EditText) findViewById(R.id.et_code_value);
        bikePwd = (EditText) findViewById(R.id.et_pwd_value);
        bikeResult = (EditText) findViewById(R.id.et_result);

        btnWrite = (Button) findViewById(R.id.btn_write);
        btnWrite.setOnClickListener(new SaveListener(bikeCode, bikePwd));
        btnRead = (Button) findViewById(R.id.btn_read);
        btnRead.setOnClickListener(new ReadListener(bikeCode, bikeResult));
        btnReadAll = (Button) findViewById(R.id.btn_read_all);
        btnReadAll.setOnClickListener(new ReadAllListener(bikeCode, bikeResult));

        btnImport = (Button) findViewById(R.id.btn_import);
        btnImport.setOnClickListener(new ImportDataistener(OFCActivity.this));

        btn_export = (Button) findViewById(R.id.btn_export);
        btn_export.setOnClickListener(new ExportDataistener(OFCActivity.this));

        init();
    }

    private void init() {
//        bikeResult.setFocusable(false);
        bikeResult.setEnabled(false);
        this.ofcService = new OFCService(OFCActivity.this);
    }


    class SaveListener implements View.OnClickListener {

        private EditText bikeCode;

        private EditText bikePwd;

        public SaveListener(EditText bikeCode, EditText bikePwd) {
            this.bikeCode = bikeCode;
            this.bikePwd = bikePwd;
        }


        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(OFCActivity.this)
                    .setTitle("确认保存？")
                    .setMessage("车号：" + bikeCode.getText() + "\n密码：" + bikePwd.getText())
                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            BikeEntiry entiry = new BikeEntiry();
                            entiry.setCode(bikeCode.getText().toString());
                            entiry.setPwd(bikePwd.getText().toString());
                            if (!"".equals(bikeCode.getText().toString().trim())
                                    && !"".equals(bikePwd.getText().toString().trim())) {
                                ofcService.save(entiry);
                                Toast.makeText(OFCActivity.this, "已经保存", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(OFCActivity.this, "信息不完整", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("否", null)
                    .show();
        }
    }

    class ReadListener implements View.OnClickListener {

        private EditText bikeCode;

        private EditText bikeResult;

        public ReadListener(EditText bikeCode, EditText bikeResult) {
            this.bikeCode = bikeCode;
            this.bikeResult = bikeResult;
        }


        @Override
        public void onClick(View v) {
            String bikeCode = this.bikeCode.getText().toString();
            if (bikeCode != null && !"".equals(bikeCode.trim())) {
                BikeEntiry entiry = ofcService.findOne(bikeCode);
                if (entiry != null) {
                    bikeResult.setText("车号：" + entiry.getCode() + "\n密码：" + entiry.getPwd());
                    Toast.makeText(OFCActivity.this, "密码获取成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OFCActivity.this, "车号【" + bikeCode + "】的密码不存在", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(OFCActivity.this, "请输入车号", Toast.LENGTH_SHORT).show();
            }

        }
    }

    class ReadAllListener implements View.OnClickListener {

        private EditText bikeCode;

        private EditText bikeResult;

        public ReadAllListener(EditText bikeCode, EditText bikeResult) {
            this.bikeCode = bikeCode;
            this.bikeResult = bikeResult;
        }


        @Override
        public void onClick(View v) {
            List<BikeEntiry> entiryList = ofcService.findAll();
            StringBuilder codeList = new StringBuilder();
            if (entiryList != null && entiryList.size() > 0) {
                for (BikeEntiry entiry : entiryList) {
                    codeList.append("车号：").append(entiry.getCode()).append("\t")
                            .append("密码：").append(entiry.getPwd()).append("\n");
                }
                bikeResult.setText(codeList.toString());
                Toast.makeText(OFCActivity.this, "密码获取成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(OFCActivity.this, "库中未存密码", Toast.LENGTH_SHORT).show();
            }

        }
    }

    class ImportDataistener implements View.OnClickListener {

        private EditText bikeCode;

        private EditText bikeResult;

        private Intent intent;

        private Context context;

        public ImportDataistener(Context context) {
            this.context = context;
        }


        @Override
        public void onClick(View v) {
            showFileChooser();

        }

        private void showFileChooser() {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            try {
                startActivityForResult(Intent.createChooser(intent, "请选择一个要导入的文件"),
                        FILE_READ);
            } catch (android.content.ActivityNotFoundException ex) {
                // Potentially direct the user to the Market with a Dialog
                Toast.makeText(context, "请安装文件管理器", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class ExportDataistener implements View.OnClickListener {

        private EditText bikeCode;

        private EditText bikeResult;

        private Intent intent;

        private Context context;

        public ExportDataistener(Context context) {
            this.context = context;
        }


        @Override
        public void onClick(View v) {
            String extBaseDir = null;
            List<BikeEntiry> allBike = ofcService.findAll();
            try {
                extBaseDir = Environment.getExternalStorageDirectory().getCanonicalPath()+"/download-ofc";
                File dir = new File(extBaseDir);
                if (!dir.exists()){
                    dir.mkdirs();
                }
                String pathname = extBaseDir + "/" + FILE_NAME;
                CSVFileOper.writeFile(pathname,allBike);
                Toast.makeText(context, "输出文件："+pathname, Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(context, "输出目录不存在", Toast.LENGTH_LONG).show();
            }
        }

        private void showFileChooser() {
            intent = new Intent(Intent.ACTION_GET_RESTRICTION_ENTRIES);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            try {
                startActivityForResult(Intent.createChooser(intent, "请选择一个要导出的目录位置"),
                        FILE_WRITE);
            } catch (android.content.ActivityNotFoundException ex) {
                // Potentially direct the user to the Market with a Dialog
                Toast.makeText(context, "请安装文件管理器", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FILE_READ){
            handlerReadResult(resultCode, data);
        }else if (requestCode == FILE_WRITE){
            handlerWriteResult(resultCode,data);
        }
    }

    private void handlerWriteResult(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            List<BikeEntiry> allBike = ofcService.findAll();
            if (allBike != null && allBike.size() > 0){
                String baseDir = Environment.getExternalStorageState();
                Toast.makeText(OFCActivity.this, "文件路径为：" + baseDir, Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void handlerReadResult(int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String path = uri.getPath();
            Toast.makeText(OFCActivity.this, "文件路径为：" + path, Toast.LENGTH_SHORT).show();
            try {
                List<BikeEntiry> allBikes = CSVFileOper.readFile(path);
                if (allBikes != null && allBikes.size() > 0) {
                    for (BikeEntiry bike : allBikes) {
                        if (bike != null && bike.getCode() != null && bike.getPwd() != null
                                && !"".equals(bike.getCode().trim()) && !"".equals(bike.getPwd().trim())) {
                            ofcService.save(bike);
                        }
                    }
                    Toast.makeText(OFCActivity.this, "文件数据导入成功", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                Toast.makeText(OFCActivity.this, "读取文件失败," + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(OFCActivity.this, "获取路径失败", Toast.LENGTH_SHORT).show();
        }
    }
}
