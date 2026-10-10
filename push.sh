#!/bin/bash
# Run from inside the java-practice folder: bash push.sh
set -e
git init -q -b main
git add .
git commit -q -m "Initial commit"
gh repo create java-practice --public --source=. --push
