call runcrud.bat
if "%ERRORLEVEL%" == "0" goto secondcall
echo.
echo Cannot run runcrud
goto fail

:secondcall
start chrome "https://kodilla.com/pl"
start chrome "http://localhost:8080/crud/v1/tasks"
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open websides
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.