import processing.video.*;

void setup()
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

void draw()
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
        if (random(0,1) < 0.5) 
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

void movieEvent(Movie m) {
  m.read();
}

void removeAllEffects() {
  a = false; b = false; c = false; d = false; e = false; f = false; g = false; h = false; i = false;
  j = false; k = false; l = false; m = false; n = false; o = false; p = false; q = false; r = false; 
  s = false; t = false; u = false; v = false; w = false; x = false; y = false; z = false;  
}



// Improve distortion effect (save the frame before distorting and use that to distort off of the next time)
// Give opacity to noise
// try to figure this out - http://geotypografika.com/2010/04/29/karel-martens-chaumont-2010/
