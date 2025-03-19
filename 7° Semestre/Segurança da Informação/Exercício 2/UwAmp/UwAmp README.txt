 _   _           ___                  
| | | |         / _ \                 
| | | |_      _/ /_\ \_ __ ___  _ __  
| | | \ \ /\ / /  _  | '_ ` _ \| '_ \ 
| |_| |\ V  V /| | | | | | | | | |_) |
 \___/  \_/\_/ \_| |_/_| |_| |_| .__/ 
                               | |    
                               |_|    

01010101 01110111 01000001 01101101 01110000 
V 1.3	www.uwamp.com
--------------------------------------------


Apache config file : 
	apache\conf\httpd_source.conf

PHP config file : 
	apache\php_5.2.13\php_source.ini
	apache\php_5.3.2\php_source.ini
	apache\php_6.0_Alpha_2009-10-01\php_source.ini

MYSQL config file : 
	UwAmp\mysql\my_source.ini


MYSQL PASSWORD : 
	user : root
	password : root


Available Macro in setting: 

	{APACHEPATH} 			= UwAmp\apache
	{DOCUMENTPATH} 			= UwAmp\www
	{PHPPATH} 			= UwAmp\apache\CURRENT PHP IN UWAMP CONTROL\
	{PHPAPACHE2FILE} 		= UwAmp\apache\CURRENT PHP IN UWAMP CONTROL\CURRENT apache2.dll
	{PHPEXTPATH} 			= UwAmp\apache\CURRENT PHP IN UWAMP CONTROL\ext
	{PHPMODULENAME}			= Module name of current php version
	{LISTEN_VIRTUAL_HOST_PORT}	= Apache Listens ports

	{MYSQLPATH}			= UwAmp\mysql\
	{MYSQLBINPATH}			= UwAmp\mysql\bin
	{MYSQLDATAPATH}			= UwAmp\mysql\data

	{ONLINE_MODE}			= Order allow,deny
				  	Allow from all
			OR
					= Order deny,allow
				  	Allow from 127.0.0.1 localhost

	if ONLINE_MODE is set to Online the serveur is available for all IP
	if ONLINE_MODE is set to Offline the serveur is available just for 127.0.0.1