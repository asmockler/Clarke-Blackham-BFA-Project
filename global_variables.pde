// Global Variables

PFont unitedSans;

Capture cam;

Timer killswitch = new Timer();
Timer distortion_timer = new Timer();
int distortion_picker;
int fade = 100;

color cyan = color(44,206,235);
color green = color(39, 252, 0);
color RED = color(212, 37, 35);
color YELLOW = color(255, 255, 0);

// Red, Yellow, Green, Cyan, Magenta
color[] COLORS = { color(255, 0, 0), color(255, 255, 0), color(0, 255, 0), color(0, 255, 255), color(255, 0, 255)};

boolean a = false, b = false, c = false, d = false, e = false, f = false, g = false, h = false, i = false, j = false, k = false, l = false, m = false, n = false, o = false, p = false, q = false, r = false, s = false, t = false, u = false, v = false, w = false, x = false, y = false, z = false;

Movie heartbeat;
Movie heartbeat2;
Movie heartbeat3;
Movie pills;
Movie pills1;
Movie pills2;
Movie audio;

Text aText1 = new Text();
Text aText2 = new Text();
Text aText3 = new Text();

Text bText = new Text();

Shapes cShape1 = new Shapes();
Shapes cShape2 = new Shapes();
Shapes cShape3 = new Shapes();
Shapes cShape4 = new Shapes();
Shapes cShape5 = new Shapes();
Shapes cShape6 = new Shapes();
Shapes cShape7 = new Shapes();

Shapes dShape = new Shapes();

Text hText = new Text();

Shapes iShape = new Shapes();

Text mText = new Text();

Shapes[] orbitArray_cyan = new Shapes[500];
Shapes[] orbitArray_green = new Shapes[500];
Shapes[] orbitArray_red = new Shapes[500];

Shapes vShape = new Shapes();
