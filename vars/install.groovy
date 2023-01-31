#!/usr/bin/env groovy

def call(String packageName){
    sh 'pip3 install ${packageName}'
}

