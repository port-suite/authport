# Authport

### The basics
Authentication service for the [port-suite](https://github.com/port-suite). Handles account information and authentication tokens.

`authport` is written in Java with Maven, to properly start the server you must have Maven installed on your machine.

`authport` must be active for other services in the suite to function properly. To start the server, you will firstly need to make sure
that you are located in the `auth` directory. Then simply run:
```bash
  # Linux or MacOS
  ./start-server.sh

  # No Windows alternative. Open the shell script, have a look at the mvn command and look up the Windows alternative
```
### First timers, look this way!
If it is the first time setting up `authport` you will need to setup the database. In the `auth` directory there is a python-script for doing just that.
To have an as smooth experience as possible, you'll need to have the python package manager `uv` installed. If you don't and want to install it, simply
run this command:
```bash
  # Linux or MacOS
  curl -LsSf https://astral.sh/uv/install.sh | sh
  
  # Windows (if you for some unexplainable reason use that for development)
  powershell -ExecutionPolicy ByPass -c "irm https://astral.sh/uv/install.ps1 | iex"
```
If you don't wish to install `uv`, I'm sorry to say: you're on your own.

When you have `uv` installed, run the following command to initialize the database:
```bash
  uv run migrate.py
```
When all this is done, you are ready to start the server:
```bash
  # Linux or MacOS
  ./start-server.sh

  # No Windows alternative. Open the shell script, have a look at the mvn command and look up the Windows alternative
```
