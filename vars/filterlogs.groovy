#!/usr/bin/evn groovy

// creating this function to filter the logs based on the keyword passed in.

import org.apache.commons.lang.StringUtils

def call(String filter_string, int occurences,int log_num = 1000){
    def logs  = currentBuild.rawBuild.getLog(log_num).join('\n')

    int count = StringUtils.countMatches(logs, filter_string);
    
    if (filter_string == 'ERROR' && count >= 1 ){
        currentBuild.result = "UNSTABLE"
    }


    if(count > occurences -1 ){
        currentBuild.result = 'UNSTABLE' 
    }
     
}





