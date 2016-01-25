/*********** redis transaction������� **********/
1.
DISCARD -
summary: Discard all commands issued after MULTI
since: 2.0.0

EXEC -
summary: Execute all commands issued after MULTI
since: 1.2.0

MULTI -
summary: Mark the start of a transaction block
since: 1.2.0

UNWATCH -
summary: Forget about all watched keys
since: 2.2.0

WATCH key [key ...]
summary: Watch the given keys to determine execution of the MULTI/EXEC block
since: 2.2.0

