#!/usr/bin/env bash

mvn clean package

echo 'Copy Files...'

scp -i D:\testkey \
    out/artifacts/StemDiary_jar/StemDiary.jar \
    ubuntu@18.191.156.108:/home/ubuntu/stemDiaryWesServer

echo 'Restart server'

ssh -i D:\testkey ubuntu@18.191.156.108 << EOF

pgrep java | xargs kill -9
nohup java -jar StemDiary.jar > log.txt &

EOF

echo 'bye'