#!/bin/sh

WEEK_1=10
FORCE_ZIP=false 
CURRENT_WEEK=$(date +%U)
CURRENT_DELIVERY_WEEK=$(((CURRENT_WEEK-WEEK_1)+1))
CURRENT_DELIVERY_ZIP="iasa45741.zip"
ls ./delivery/${CURRENT_DELIVERY_ZIP} > /dev/null
echo $?
FILE_EXISTS=$(echo $?)


# Usage
# sh delivery_tp1.sh -f # to force the zip
#sh delivery_tp1.sh # to zip


while getopts f flag
do
    case "${flag}" in
        f) FORCE_ZIP=true;;
    esac
done

if [ $FILE_EXISTS -ge 0 ] || [ $FORCE_ZIP = true ]
then

    if [ $FORCE_ZIP = true ]
    then
        echo "Force Creating ZIP $CURRENT_DELIVERY_ZIP"
    else
        echo "Creating ZIP $CURRENT_DELIVERY_ZIP"
    fi

    zip -r ${CURRENT_DELIVERY_ZIP} iasa45741 > /dev/null

else
    echo "ZIP $CURRENT_DELIVERY_ZIP already exists"
fi
