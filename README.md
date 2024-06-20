# Auto-X IoT

## Features
### Agents
- Auto-X AI Server
- Eclipse Ditto
- Auto-X Studio
- Auto-X ERP

### Asset List
- Building Asset
- City Asset
- Parking Asset
- Room Asset
- Ship Asset

- Electric Vehicle Asset
- Electricity Asset (Provider and Consumer)
- Gas Asset (Provider and Consumer)
- Water Asset (Provider and Consumer)
- Gauge Asset
- Light Asset
- PV Solar Asset
- Wind Turbine Asset
- Weather Asset
- Environment Sensor Asset

- People Counter Asset
- Drone Asset

### Widgets for Visualization
- Image
- Line Chart
- Gauge
- Table
- Map
- Gateway
- Attribute
- KPI
- Report
- Drone Mission Planner

## Quickstart

The quickest way to get your own environment with full access is to make use of our docker images (both `amd64` and `arm64` are supported). 
1. Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) installed (v18+). 
2. Download the docker compose file:
[OpenRemote Stack](https://raw.githubusercontent.com/openremote/openremote/master/docker-compose.yml) (Right click 'Save link as...')
1. In a terminal `cd` to where you just saved the compose file and then run:
```
    docker-compose pull
    docker-compose -p openremote up
```
If all goes well then you should now be able to access the OpenRemote Manager UI at [https://localhost](https://localhost). You will need to accept the self-signed 
certificate, see [here](https://www.technipages.com/google-chrome-bypass-your-connection-is-not-private-message) for details how to do this in Chrome (similar for other browsers).


### Login credentials
Username: admin  
Password: secret

### Changing host and/or port
The URL you use to access the system is important, the default is configured as `https://localhost` if you are using a VM or want to run on a different port then you will need to set the `OR_HOSTNAME` and `OR_SSL_PORT` environment variables, so if for example you will be accessing using `https://192.168.1.1:8443` then use the following startup command:

BASH: 
```
OR_HOSTNAME=192.168.1.1 OR_SSL_PORT=8443 docker-compose -p openremote up -d
```
or

CMD:
```
cmd /C "set OR_HOSTNAME=192.168.1.1 && set OR_SSL_PORT=8443 && docker-compose -p openremote up -d"
```
