/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 *  3. Ненужные комментарии
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий человека, создаваемого разными способами.
 * Поддерживает имя в виде строки или объекта NameEx4, а также связь с отцом.
 */
class PersonConstructor {
  private NameEx4 name;
  private int height;
  private PersonConstructor father;

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает имя человека.
   *
   * @return объект NameEx4, представляющий имя
   */
  public NameEx4 getName() {
    return name;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает рост человека.
   *
   * @return рост в сантиметрах
   */
  public int getHeight() {
    return height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает отца человека.
   *
   * @return объект PersonConstructor, представляющий отца, или null
   */
  public PersonConstructor getFather() {
    return father;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с именем в виде строки и ростом.
   *
   * @param firstName личное имя
   * @param height  рост человека в сантиметрах
   */
  public PersonConstructor(String firstName, int height) {
    this.name = new NameEx4(firstName);
    this.height = height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с именем в виде строки, ростом и отцом.
   * После создания автоматически обновляет фамилию и отчество
   * на основе данных отца.
   *
   * @param firstName личное имя
   * @param height  рост человека в сантиметрах
   * @param father  объект PersonConstructor, представляющий отца
   */
  public PersonConstructor(String firstName, int height, PersonConstructor father) {
    this(firstName, height);
    this.father = father;
    updateNameFromFather();
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с именем в виде объекта NameEx4 и ростом.
   *
   * @param name   объект NameEx4, представляющий имя
   * @param height рост человека в сантиметрах
   */
  public PersonConstructor(NameEx4 name, int height) {
    this.name = name;
    this.height = height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с именем в виде объекта NameEx4, ростом и отцом.
   * После создания автоматически обновляет фамилию и отчество
   * на основе данных отца.
   *
   * @param name   объект NameEx4, представляющий имя
   * @param height рост человека в сантиметрах
   * @param father объект PersonConstructor, представляющий отца
   */
  public PersonConstructor(NameEx4 name, int height, PersonConstructor father) {
    this.name = name;
    this.height = height;
    this.father = father;
    updateNameFromFather();
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Приватный конструктор, используемый для внутренних нужд.
   * Не выполняет обновление имени на основе данных отца.
   *
   * @param name   объект NameEx4
   * @param height рост человека
   * @param father отец
   * @param dummy  фиктивный параметр для различения сигнатур
   */
  private PersonConstructor(NameEx4 name, int height, PersonConstructor father, boolean dummy) {
    this.name = name;
    this.height = height;
    this.father = father;
  }

  /**
   * Обновляет фамилию и отчество на основе данных отца.
   * Если фамилия не задана, наследует фамилию отца.
   * Если отчество не задано, формирует его из имени отца.
   */
  private void updateNameFromFather() {
    if (father != null && father.name != null) {
      String currentFirstName = name.getFirstName();
      String currentLastName = name.getLastName();
      String currentMiddleName = name.getMiddleName();

      if ((currentLastName == null || currentLastName.isEmpty()) &&
          father.name.getLastName() != null && !father.name.getLastName().isEmpty()) {
        currentLastName = father.name.getLastName();
      }

      if ((currentMiddleName == null || currentMiddleName.isEmpty()) &&
          father.name.getFirstName() != null && !father.name.getFirstName().isEmpty()) {
        currentMiddleName = father.name.getFirstName() + "ович";
      }

      this.name = new NameEx4(currentFirstName, currentLastName, currentMiddleName);
    }
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление человека.
   * Формат: "<Имя Фамилия Отчество>, рост: <число>"
   *
   * @return строка с описанием человека
   */
  @Override
  public String toString() {
    return name + ", рост: " + height;
  }
}