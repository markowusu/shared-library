#!/usr/bin/env groovy

def call(){
    echo "Installing requirements.txt"
    sh 'install -r requirements.txt'
}

