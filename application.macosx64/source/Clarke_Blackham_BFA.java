import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Clarke_Blackham_BFA extends PApplet {



public void setup()
{
  // Canvas Size
  size(1280, 720);
  frameRate(30);
  setupCamera(); 
 

  
  unitedSans = loadFont("UnitedSans-Black-150.vlw");
  textFont(unitedSans);
  
  for (int count = 0; count < 500; count++)
  {
    orbitArray_cyan[count] = new Shapes();
    orbitArray_cyan[count].orbitSetup_cyan();
    
    orbitArray_green[count] = new Shapes();
    orbitArray_green[count].orbitSetup_green();
    
    orbitArray_red[count] = new Shapes();
    orbitArray_red[count].orbitSetup_red();
  }

}

public void draw()
{
  background(255);
  blendMode(BLEND);
  if (f || g || j || k || l || r) blendMode(MULTIPLY);
  if (e) blendMode(EXCLUSION);
  
  //Draw the Camera image
  if (cam.available() == true) {
    cam.read(); 
  }
  image(cam, 0, 0);
  
  //background(51);
  
  // Import Heartbeat Video
  heartbeat = new Movie(this, "linez.mov");
  heartbeat.loop();
  
  heartbeat2 = new Movie(this, "LINEZ-2.mov");
  heartbeat2.loop();
    
  heartbeat3 = new Movie(this, "LINEZ-3.mov");
  heartbeat3.loop();
  
  // Import Pills Video
  pills = new Movie(this, "Pillz 2.mov");
  pills.loop();
  
  pills1 = new Movie(this, "Pillz 3.mov");
  pills1.loop();
  
  pills2 = new Movie(this, "pillz-3.2.mov");
  pills2.loop();

  // Audio
  audio = new Movie(this, "AUDIO.mov");
  audio.volume(0);
  audio.loop();
  if (f) {
    image(heartbeat,0,0,width,height);
  }
  if (g) {
    image(pills,0,0,width,height);
    image(pills,0,0,width,height); 
    image(pills,0,0,width,height); 
  }
  if (j) {
    image(pills1,0,0,width,height);
    image(pills1,0,0,width,height);
    image(pills1,0,0,width,height);
  }
  if (k) {
    image(pills2,0,0,width,height);
    image(pills2,0,0,width,height); 
    image(pills2,0,0,width,height);
  }
  if (l) {
    image(heartbeat2,0,0,width,height);  
  }
  if (r) {
    image(heartbeat3,0,0,width,height);
  }
  if (s) {
    audio.volume(1);
  } else { audio.volume(0); }
  blendMode(BLEND);
  if (e) blendMode(EXCLUSION);
  if (a) {
    aText1.randomWords(200, 500, 50, 100, "lg");
    aText2.randomWords(400, 800, 200, 450, "lg");
  }
  if (b) {
    bText.randomWords(300, 500, 35, 75, "md");
  }
  if (c) { 
    cShape1.randomRect((int)random(500));
    cShape2.randomRect((int)random(500));
    cShape3.randomRect((int)random(500));
    cShape4.randomRect((int)random(500));
    cShape5.randomRect((int)random(500));
    cShape6.randomRect((int)random(500));
    cShape7.randomRect((int)random(500));
  }
  if (d) dShape.largeRect();
  if (h) hText.silence();
  if (i) iShape.dots();
  if (q) removeAllEffects();
  if (m) mText.placebo();
  if (n) bText.randomWords_fast(100);
  if (o) {
    aText1.randomWords(250, 400, 14, 18, "sm");
    aText2.randomWords(450, 800, 25, 40, "md");
  }
  if (p) {
    for (int count = 0; count < 500; count++)
    {   
      orbitArray_red[count].setOrbitColor(RED); 
      orbitArray_red[count].orbit();  
    }
    
    for (int count = 0; count < 100; count++)
    {
      orbitArray_cyan[count].orbit();
      orbitArray_green[count].orbit();    
    }
  }
  if(t) {
    for (int count = 0; count < 200; count++)
    {
      orbitArray_cyan[count].orbit1(); 
      orbitArray_green[count].orbit1(); 
      orbitArray_red[count].setOrbitColor(RED);    
      orbitArray_red[count].orbit1(); 
    } 
  }
  if(u) {
    for (int count = 0; count < 300; count++)
    {
      orbitArray_cyan[count].orbit2(); 
      orbitArray_green[count].orbit2(); 
      orbitArray_red[count].setOrbitColor(YELLOW); 
      orbitArray_red[count].orbit2(); 
    } 
  }
  if(v) {
    vShape.dotsSmall();
  }
  
  // Keypress distortion effects
  
  if (distortion_picker == 1) {
    if ( !distortion_timer.check(500) ) {
      loadPixels();
      for ( int i = (int)random((width/5)*height, (width/2)*height); i < (int)random((width*height) - (width * 15), (width*height)); i++ )
      {
        pixels[i] = pixels[i - (width/10)];
      }
      updatePixels();
    }
  } else if (distortion_picker == 2) {
    if ( !distortion_timer.check(200) ) {
      loadPixels();
      for( int count = 0; count < height*width; count++ )
      {
        if (random(0,1) < 0.5f) 
          pixels[count] = color(0,0,0,20);
        else
          pixels[count] = color(255,255,255,20);
      } 
      updatePixels();
    }
  } else if (distortion_picker == 3) {
    if ( !distortion_timer.check(500) ) {
      fill(255, 24, 46, fade);
      rect(0, 0, width, height);
      fade--;
    }
  }
  
  // Killswitch
  if (killswitch.check(30000)) removeAllEffects();
  // Save images
  if (!killswitch.check(30000)) saveFrame("img-######.jpg");
}

public void movieEvent(Movie m) {
  m.read();
}

public void removeAllEffects() {
  a = false; b = false; c = false; d = false; e = false; f = false; g = false; h = false; i = false;
  j = false; k = false; l = false; m = false; n = false; o = false; p = false; q = false; r = false; 
  s = false; t = false; u = false; v = false; w = false; x = false; y = false; z = false;  
}



// Improve distortion effect (save the frame before distorting and use that to distort off of the next time)
// Give opacity to noise
// try to figure this out - http://geotypografika.com/2010/04/29/karel-martens-chaumont-2010/
public void setupCamera()
{
    // Setup Camera
    String[] cameras = Capture.list();
  
    if (cameras == null) {
      println("Failed to retrieve the list of available cameras, will try the default...");
      cam = new Capture(this, 640, 480);
    } if (cameras.length == 0) {
      println("There are no cameras available for capture.");
      exit();
    } else {
      println("Available cameras:");
      for (int i = 0; i < cameras.length; i++) {
        println(cameras[i]);
      }

      // The camera can be initialized directly using an element
      // from the array returned by list():
      cam = new Capture(this, cameras[0]);
      // Or, the settings can be defined based on the text in the list
      //cam = new Capture(this, 640, 480, "Built-in iSight", 30);
      
      // Start capturing the images from the camera
      cam.start();
    } 
}

// Global Variables

PFont unitedSans;

Capture cam;

Timer killswitch = new Timer();
Timer distortion_timer = new Timer();
int distortion_picker;
int fade = 100;

int cyan = color(44,206,235);
int green = color(39, 252, 0);
int RED = color(212, 37, 35);
int YELLOW = color(255, 255, 0);

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
// Toggles boolean values for each key to control
// which variation is happening
public void keyPressed() {
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
class Shapes {
  float X1 = 0;
  float X2 = 0;
  float Y1 = 0;
  float Y2 = 0;
  Timer timer = new Timer();
  
  float slideSpeed = random(15, 50);
  boolean slideUp = true;
  
  float orbitRadius;
  float orbitSpeed;
  int orbitColor;

  public void orbitSetup_cyan() {
    orbitRadius = random(100, 200);
    orbitSpeed = random(500, 1000);
    orbitColor = color(44,206,235);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  public void orbitSetup_red() {
    orbitRadius = random(200, 300);
    orbitSpeed = random(500, 1000);
    orbitColor = color(212, 37, 35);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  public void orbitSetup_green() {
    orbitRadius = random(150, 250);
    orbitSpeed = random(500, 1000);
    orbitColor = color(39, 252, 0);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  public void setOrbitColor(int col) {
    this.orbitColor = col;  
  }

  public void orbit() {
    float t = millis()/orbitSpeed;
    X1 = ((width/2) + orbitRadius * cos(t));
    Y1 = ((height/2) + orbitRadius * sin(t)); 
    // x1, y1, x2, y2, x3, y3
    noStroke();
    fill(orbitColor);
    triangle(X1, 
             Y1, 
             X1 + 5,
             Y1 + 15,
             X1 + 10,
             Y1
//             // Point 2
//             ((width/2) + (orbitRadius+10) * cos(t)),
//             ((width/2) + (orbitRadius+10) * sin(t)),
//             // Point 3
//             ((width/2) + (orbitRadius-10) * cos(t)),
//             ((width/2) + (orbitRadius-10) * sin(t))
            );
  }
  
  public void orbit1() {
    float t = millis()/orbitSpeed;
    X1 = ((width/2) + (orbitRadius + (10000/orbitRadius)) * cos(t));
    Y1 = ((height/2) + (orbitRadius + (10000/orbitRadius)) * sin(t)); 
    // x1, y1, x2, y2, x3, y3
    noStroke();
    fill(orbitColor);
    triangle(X1, 
             Y1, 
             // Point 2
             X1 + 22*cos(t) + 13*sin(t),
             Y1 + 17*sin(t) - 17*cos(t),
             // Point 3
             X1 - 15*cos(t) - 20 * cos(t),
             Y1 + 18*sin(t) - 9 * sin(t)
            );
  }
  
  public void orbit2() {
    float t = millis()/orbitSpeed*1.25f;
    X1 = ((width/2) + orbitRadius * cos(t)) + 5;
    Y1 = ((height/2) + orbitRadius * sin(t)) + 5; 
    // x1, y1, x2, y2, x3, y3
    noStroke();
    fill(orbitColor);
    triangle(X1, 
             Y1, 
             // Point 2
             X1 - 10*cos(t)*-1 - 5 * sin(t),
             Y1 + 15*cos(t)*-1 - 5 * sin(t),
             // Point 3
             X1 - 15*cos(t) - 5 * sin(t),
             Y1 + 10*cos(t) - 10 * sin(t)
            );
  }
  
  public void randomRect(int speed) {
    if(timer.check(speed)) {
      X1 = random(1, width-50);
      X2 = random(100, width/4);
      Y1 = random(height / 2, height - 10);
      Y2 = random(10, 20);
      timer.reset();
    } 
    noStroke();
    blend( (int)X1, (int)Y1, (int)X2, (int)Y2, (int)X1, (int)Y1, (int)X2, (int)Y2, DODGE);
    fill(224, 40, 95, 50);
    rect(X1, Y1, X2, Y2);
  }
  
  
  public void largeRect() {
    
    if ( Y1 > height*.9f && !slideUp )
    {
       slideSpeed = random(-50, -15);
       slideUp = !slideUp;
    }
    else if ( Y1 < height * .1f && slideUp )
    {
      slideSpeed = random(15, 50);
      slideUp = !slideUp;
    }
    
    Y1 += slideSpeed;
    
    println(Y1);
    
    noStroke();
    fill(255, 0, 0, 100);
    rect( (width/2), Y1, (width/2), height*2);
    
   
  }
  
  public void dots() {
    noStroke();
    fill(255, 255, 255, 75);
    
    int offset = 0;
    // rows
    for (int i = -10; i < (height/20); i++)
    {
      offset += 5;
      // columns
      for (int j = -10; j < (width/20); j++)
      {
        ellipse((j*20) + offset + X1, (i * 20) + 10, 15, 15);
      }
    }
    if ( X1 == -32 ) {
      X1 = -12;  
    } else {
      X1 -= 2;
    }
  }
  
  public void dotsSmall() {
    noStroke();
    fill(255, 255, 255, 75);
  
    int offset = 0; 
    for (int i = -10; i < (height/15); i++)
    {
      offset += 5;
      // columns
      for (int j = -20; j < (width/15); j++)
      {
        ellipse((j*20) + offset, (i * 20) + 10 + Y1, 6, 6);
      }
    }
    
    if ( Y1 == -16 ) {
      Y1 = 0;  
    } else {
      Y1 -= 2;
    }
  }
  
}
class Text
{
  String words_lg[] = {"physical", "social", "participate", "choice", "control"};
  String words_md[] = {"brain", "power", "imagination", "mind", "unique", "information", "personal", "desire", "behavior", "facts"};
  String words_sm[] = {"expectation", "conscious", "consciousness", "unconscious", "pattern", "belief", "manipulate", "anxiety", "culture", "meaning", "threat", "perspective", "indirect", "terminal", "effect", "possible", "nature", "system", "communicate", "report", "study", "why"};

  String currentWord;
  Timer timer = new Timer();
  float x;
  float y;
  float size;

  Text () {
    currentWord = "brain";
    x = random(width - 50);
    y = random(height);
  }

  public void switchWord(String generalSize)
  {
    if ( generalSize.equals("lg") ) {
      currentWord = words_lg[(int)random(0, 5)];
    } else if ( generalSize.equals("md") ) {
      currentWord = words_md[(int)random(0, 10)];
    } else if ( generalSize.equals("sm") ) {
      currentWord = words_sm[(int)random(0, 22)];
    } else {
      println("Could not interpret parameter '" + generalSize + "'. Please pass sm, md, or lg.");
    }
  }

  public void randomWords(int lowerSpeed, int upperSpeed, int minSize, int maxSize, String type) {
    int word_time = (int)random(lowerSpeed, upperSpeed);
    if (timer.check(word_time)) {
      this.size = random(minSize, maxSize);
      switchWord(type);
      x = random(width - 50);
      y = random(height);
      timer.reset();
    }
    fill(255, 0, 0);
    textSize(this.size);
    text(currentWord, x, y);
  }

  public void randomWords_fast(int frequency) {
    for(int count = 0; count < 100; count++)
    {
      switchWord("sm");
      x = random(width - 50);
      y = random(height);
      textSize(12);
      fill(255,0,0);
      text(currentWord, x, y);
    }
  }

  public void placebo() {
    fill(255, 255, 255, 20);
    textSize(width/5);
    textAlign(CENTER);
    text("PLACEBO", width/2, height/2);
  }

  public void silence() {
    fill(0,0,0);
    textSize(width/10);
    textAlign(CENTER);
    text("YOU ARE", width / 2, (height / 2) - width/10);
    text("LISTENING", width / 2, (height / 2) );
    text("TO SILENCE", width / 2, (height / 2) + width/10);
  }

}
class Timer
{
  int timerStart;
  int currentTime;
  
  Timer() {
    timerStart = millis(); 
  }
  
  // You pass a number of milliseconds, it checks if
  // that amount of time has passed yet
  public boolean check(int check)
  {
    boolean result = false;
    
    currentTime = millis();
    if ( currentTime - timerStart > check)
    {
      result = true;
    }
    else
    {
      result = false;
    }
    
    return result;
  }
  
  // Resets the timer
  public void reset()
  {
   timerStart = millis(); 
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#000000", "--hide-stop", "Clarke_Blackham_BFA" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
