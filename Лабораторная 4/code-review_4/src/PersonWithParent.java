/**
 *  FIXME:
 *  1. Используется табуляция
 *  2. Не хватает Javadoс
 *  3. Ненужные комментарии
 */

/* FIXME: Не хватало javadoc */
/**
 * Класс, представляющий человека с возможной родительской связью.
 * Позволяет хранить имя, рост и ссылку на отца, а также автоматически
 * наследовать фамилию и отчество от родителя.
 */
class PersonWithParent {
  private Name name;
  private int height;
  private PersonWithParent father;

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает имя человека.
   *
   * @return объект Name, представляющий имя
   */
  public Name getName() {
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
   * @return объект PersonWithParent, представляющий отца, или null
   */
  public PersonWithParent getFather() {
    return father;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с указанным именем и ростом.
   *
   * @param name   объект Name, представляющий имя
   * @param height рост человека в сантиметрах
   */
  public PersonWithParent(Name name, int height) {
    this.name = name;
    this.height = height;
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Создаёт человека с указанным именем, ростом и отцом.
   * После создания автоматически обновляет фамилию и отчество
   * на основе данных отца.
   *
   * @param name   объект Name, представляющий имя
   * @param height рост человека в сантиметрах
   * @param father объект PersonWithParent, представляющий отца
   */
  public PersonWithParent(Name name, int height, PersonWithParent father) {
    this.name = name;
    this.height = height;
    this.father = father;
    updateNameFromFather(); // Обновляем имя на основе данных отца
  }

  /** Устанавливает связь с отцом для текущего человека.
   * После установки отца автоматически обновляет имя, фамилию и отчество
   * в соответствии с данными отца (например, наследуется фамилия отца).
   *
   * @param father объект PersonWithParent, представляющий отца.
   * Если передается {@code null}, связь с отцом удаляется
   * и связанные с отцом данные сбрасываются.
   */
  public void setFather(PersonWithParent father) {
    this.father = father;
    updateNameFromFather();
  }

  /**
   * Обновляет фамилию и отчество на основе данных отца.
   * Если фамилия или отчество не заданы, наследует их от отца.
   */
  private void updateNameFromFather() {
    if (father != null && father.name != null) {
      if ((name.getLastName() == null || name.getLastName().isEmpty()) &&
          father.name.getLastName() != null && !father.name.getLastName().isEmpty()) {
        name = new Name(father.name.getLastName(), name.getFirstName(), name.getMiddleName());
      }

      if ((name.getMiddleName() == null || name.getMiddleName().isEmpty()) &&
          father.name.getFirstName() != null && !father.name.getFirstName().isEmpty()) {
        name = new Name(name.getLastName(), name.getFirstName(), father.name.getFirstName() + "ович");
      }
    }
  }

  /* FIXME: Не хватало javadoc */
  /**
   * Возвращает строковое представление человека.
   * Формат: "<ФИО>, рост: <число> (сын <имя_отца>а)"
   *
   * @return строка с описанием человека
   */
  @Override
  public String toString() {
    return name + ", рост: " + height + (father != null ? " (сын " + father.name.getFirstName() + "а)" : "");
  }
}