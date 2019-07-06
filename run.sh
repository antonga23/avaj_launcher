#!/bin/sh
find . -name "*.class" -type f -delete
printf "\e[92mdeleting all existing .class files\n"
echo "\n"

find * -name "*.java" > sources.txt
javac @sources.txt

echo "compiling all sources...\n"
echo "\n"

java simulator.Simulator scenario.txt 

echo "java simulator.Simulator scenario.txt"
echo "\n"
echo "[GREAT SUCCESS]"
echo "\n"

find . -name "*.class" -type f -delete

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

cat simulation.txt

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "

echo "						ROFL:ROFL:ROFL:ROFL"
echo "						___ ^_____     "
echo "					L    ___/         [ ]  "
echo "					LOL===_                "
echo "					L     \_____________]  "
echo "						___I______I__  "
