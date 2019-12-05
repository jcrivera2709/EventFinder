package application;

/**
 * Enum of all the categories. This enum will be used for chart outputs.
 *
 * @author Jose Rivera, Jose Ruiz-Ramon
 */
public enum Categories {

  Pets("PETS"),
  Religion("RELI"),
  Cars("CARS"),
  Sport("SPRT"),
  Fraternity("BROS"),
  Sorority("SNBS"),
  School("SCHO"),
  Adult("NSFW"),
  Kids("KIDS"),
  Party("PRTY");

  private final String code;

  Categories(String code) {
    this.code = code;
  }
}
