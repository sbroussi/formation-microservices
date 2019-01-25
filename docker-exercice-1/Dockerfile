#Download base image ubuntu 18.04
FROM ubuntu:18.04

# Copy script file
COPY heartbeat.sh /heartbeat.sh

# Define the ENV variable: $HEARTBEATSTEP
ENV HEARTBEATSTEP 5

# Run script
RUN chmod u+x ./heartbeat.sh
CMD ["./heartbeat.sh"]
