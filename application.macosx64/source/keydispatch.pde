// Toggles boolean values for each key to control
// which variation is happening
void keyPressed() {
  if (key == 65 || key == 97) {
    a = !a;
  } else if (key == 66 || key == 98) {
    b = !b;
  } else if (key == 67 || key == 99) {
    c = !c;
  } else if (key == 68 || key == 100) {
    d = !d;
  } else if (key == 69 || key == 101) {
    e = !e;
  } else if (key == 70 || key == 102) {
    f = !f;
  } else if (key == 71 || key == 103) {
    g = !g;
  } else if (key == 72 || key == 104) {
    h = !h;
  } else if (key == 73 || key == 105) {
    i = !i;
  } else if (key == 74 || key == 106) {
    j = !j;
  } else if (key == 75 || key == 107) {
    k = !k;
  } else if (key == 76 || key == 108) {
    l = !l;
  } else if (key == 77 || key == 109) {
    m = !m;
  } else if (key == 78 || key == 110) {
    n = !n;
  } else if (key == 79 || key == 111) {
    o = !o;
  } else if (key == 80 || key == 112) {
    p = !p;
  } else if (key == 81 || key == 113) {
    q = !q;
  } else if (key == 82 || key == 114) {
    r = !r;
  } else if (key == 83 || key == 115) {
    s = !s;
  } else if (key == 84 || key == 116) {
    t = !t;
  } else if (key == 85 || key == 117) {
    u = !u;
  } else if (key == 86 || key == 118) {
    v = !v;
  } else if (key == 87 || key == 119) {
    w = !w;
  } else if (key == 88 || key == 120) {
    x = !x;
  } else if (key == 89 || key == 121) {
    y = !y;
  } else if (key == 90 || key == 122) {
    z = !z;
  }
  
  // Reset the killswitch timer
  killswitch.reset();
  
  // Choose a distortion effect and reset the distortion timer
  distortion_picker = (int)random(1, 4);
  distortion_timer.reset();
  
  fade = 100;
  
}
