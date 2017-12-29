#!/usr/bin/python3

import sys
import csv


data = []
with open(sys.argv[1],"r") as f:
	f.readline()
	reader = csv.reader(f,delimiter=",")
	data = [list(map(float,line)) for line in reader]

minx = data[0][0]
maxx = data[0][0]
miny = data[0][1]
maxy = data[0][1]

for d in data:
	if minx > d[0]:
		minx = d[0]
	if maxx < d[0]:
		maxx = d[0]
	if miny > d[1]:
		miny = d[1]
	if maxy < d[1]:
		maxy = d[1]

with open(sys.argv[2],"w") as f:
	writer = csv.writer(f,delimiter=",");
	for d in data:
		writer.writerow([100*(d[0]-minx)/(maxx-minx),100*(d[1]-miny)/(maxy-miny),d[2]])

