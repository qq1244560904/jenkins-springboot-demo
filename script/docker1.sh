mvn jar:jar install:install help:evaluate -Dexpression=project.name
NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
echo NAME
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
echo VERSION
java -jar target/${NAME}-${VERSION}.jar