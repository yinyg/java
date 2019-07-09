echo "开始打包"
./mvnw clean package -U -DskipTests
echo "打包完成"

docker image rm my-java-application
docker image build -t my-java-application:latest .
echo "镜像编译完成"

echo "starting..."
docker container run --rm -p 8081:8081 -it my-java-application:latest
