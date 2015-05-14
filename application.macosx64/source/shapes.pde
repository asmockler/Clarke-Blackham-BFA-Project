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
  color orbitColor;

  void orbitSetup_cyan() {
    orbitRadius = random(100, 200);
    orbitSpeed = random(500, 1000);
    orbitColor = color(44,206,235);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  void orbitSetup_red() {
    orbitRadius = random(200, 300);
    orbitSpeed = random(500, 1000);
    orbitColor = color(212, 37, 35);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  void orbitSetup_green() {
    orbitRadius = random(150, 250);
    orbitSpeed = random(500, 1000);
    orbitColor = color(39, 252, 0);
    X1 = ((width/2) + orbitRadius * noise(cos(0), cos(TWO_PI)));
    Y1 = ((height/2) + orbitRadius * noise(sin(0), sin(TWO_PI)));
  }
  
  void setOrbitColor(color col) {
    this.orbitColor = col;  
  }

  void orbit() {
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
  
  void orbit1() {
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
  
  void orbit2() {
    float t = millis()/orbitSpeed*1.25;
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
  
  void randomRect(int speed) {
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
  
  
  void largeRect() {
    
    if ( Y1 > height*.9 && !slideUp )
    {
       slideSpeed = random(-50, -15);
       slideUp = !slideUp;
    }
    else if ( Y1 < height * .1 && slideUp )
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
  
  void dots() {
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
  
  void dotsSmall() {
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
