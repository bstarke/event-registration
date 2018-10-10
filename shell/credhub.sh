#!/usr/bin/env bash

cf cs credhub default event-db -c '{"username": "username","password":"password","url":"jdbc:mysql://192.168.8.38:3306/cf_0e979a96_bca6_4a02_a389_7cca40336700"}'