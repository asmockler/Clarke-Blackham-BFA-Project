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
  
  color currentColor = COLORS[(int)random(0, 5)];

  Text () {
    currentWord = "brain";
    x = random(width - 50);
    y = random(height);
  }

  void switchWord(String generalSize)
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

  void randomWords(int lowerSpeed, int upperSpeed, int minSize, int maxSize, String type) {
    int word_time = (int)random(lowerSpeed, upperSpeed);
    if (timer.check(word_time)) {
      this.size = random(minSize, maxSize);
      switchWord(type);
      x = random(width - 50);
      y = random(height);
      timer.reset();
      currentColor = COLORS[(int)random(0, 5)];
    }
    fill(currentColor);
    textSize(this.size);
    text(currentWord, x, y);
  }

  void randomWords_fast(int frequency) {
    for(int count = 0; count < 100; count++)
    {
      switchWord("sm");
      x = random(width - 50);
      y = random(height);
      textSize(12);
      currentColor = COLORS[(int)random(0, 5)];
      fill(currentColor);
      text(currentWord, x, y);
    }
  }

  void placebo() {
    fill(255, 255, 255, 20);
    textSize(width/5);
    textAlign(CENTER);
    text("PLACEBO", width/2, height/2);
  }

  void silence() {
    fill(0,0,0);
    textSize(width/10);
    textAlign(CENTER);
    text("YOU ARE", width / 2, (height / 2) - width/10);
    text("LISTENING", width / 2, (height / 2) );
    text("TO SILENCE", width / 2, (height / 2) + width/10);
  }

}
