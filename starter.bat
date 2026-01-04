@echo off
cd /d "%~dp0"
mkdir "HQ_Files"
mkdir "contents"
cd target
java -jar central_hq-1.00.0.jar
pause