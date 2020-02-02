#!/usr/bin/env bash
C:\\ProgramFiles\maven\bin\mvn clean package
echo 'Copy Files...'
scp -i /mnt/d/testkey \ /mnt/d/programmPack/программирование/StemDiary/out/artifacts/StemDiary_jar/StemDiary.jar \ ubuntu@18.191.156.108:/home/ubuntu/
echo 'Restart server'
ssh -i /mnt/d/testkey ubuntu@18.191.156.108 << EOF

pgrep java | xargs kill -9
nohup java -jar StemDiary.jar > log.txt &

EOF
echo 'bye'