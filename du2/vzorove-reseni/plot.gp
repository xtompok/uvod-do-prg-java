set xrange[0:100]
set yrange[0:100]
set datafile separator ","
set pm3d
set palette
set hidden3d
splot ARG1 matrix w l, ARG2 w points pointtype 7
pause -1
