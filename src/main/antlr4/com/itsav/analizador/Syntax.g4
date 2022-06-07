grammar Syntax;

start
:
	'hello' 'world'
;

WS
:
	[ \t\r\n]+ -> skip
;