FROM java:9
# 设置工作目录
# 复制文件到工作目录
# 设置Java环境变量
ENV PATH=$PATH:$JAVA_HOME/bin
ENV JRE_HOME=${JAVA_HOME}/jre
ENV CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
# 运行
WORKDIR /app
# COPY . /app
# ENTRYPOINT /app/run.sh
