# Auto-X IoT

## New Assets
The assets are the same as OpenRemote but with the following additions:
- Gas (Producer and Consumer) Asset
- Water (Producer and Consumer) Asset
- Electricity Meter Asset
- Gas Meter Asset
- Water Meter Asset
- Gauge Asset
- Camera Asset
- Drone Asset

## Quickstart

The quickest way to get your own environment with full access is to make use of our docker images (both `amd64` and `arm64` are supported). 
1. Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) installed (v18+). 
2. Download the docker compose file:
[OpenRemote Stack](https://raw.githubusercontent.com/openremote/openremote/master/docker-compose.yml) (Right click 'Save link as...')

3. In a terminal `cd` to where you just saved the compose file and then run:
```
./gradlew clean installDist
docker-compose -f profile/demo.yml build
docker-compose -f profile/demo.yml up -d
```

## Login credentials
Username: admin  
Password: secret

## Use Guide (Same as OpenRemote)

Please refer to [here](https://docs.openremote.io/docs/user-guide/manager-ui/)

## iOS and Android App
