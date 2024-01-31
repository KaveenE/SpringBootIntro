FROM amazoncorretto:11.0.22-alpine3.19
# Define environment variables
ENV APP_HOME /home/envuser

RUN adduser -D envuser

# Copy folder
COPY ./target/app.jar $APP_HOME/bin/app.jar
COPY ./startup.sh $APP_HOME/

# Specify the working directory
WORKDIR $APP_HOME

#Change  file permissions
RUN chmod 755 startup.sh

RUN chown -R envuser:envuser $APP_HOME
USER envuser

ENTRYPOINT ["sh","./startup.sh"]