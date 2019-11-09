package Application;

/**
 * @author Jose Rivera, Jose Ruiz-Ramon
 * This enum will be used for chart outputs.
 */
public enum Categories {

  Pets("PETS"),
  Religion("RELI"),
  Cars("CARS"),
  Sport("SPRT"),
  Fraternity("BROS"),
  Sorority("WHRS"),
  School("SCHO"),
  Adult("NSFW"),
  Kids("KIDS"),
  Party("PRTY");

  private final String code;

  Categories(String code) {
    this.code = code;
  }
}
