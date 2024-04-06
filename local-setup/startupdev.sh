# This script is used for local development only, and should be run from `gradlew startdb`
set -e
. .env

export APP='false'
me=$(basename "$0")

while test $# -gt 0; do
  case "$1" in
    -h|--help)
      echo ""
      echo "Make sure docker is running."
      echo ""
      echo "$me [options]"
      echo ""
      echo "options:"
      echo "-h, --help      show brief help"
      echo ""
      exit 0
    ;;
  esac
done

# Stops any existing containers that may conflict
docker-compose down

if [ -n "$(netstat -l -n | grep -e \"$POSTGRES_PORT\W\")" ]
  then
	echo "Database port $POSTGRES_PORT currently in use."
	exit 1
fi

# Run only postgres in detached mode
docker-compose up -d postgres

# Wait until postgres containers are ready
until docker exec support-eng-notifier-postgres pg_isready; do sleep 3 ; done
