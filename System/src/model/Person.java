package model;

public abstract class Person
{
  private Name name;

  public Person(Name name) {
    setName(name);
  }
  public String getName() {
    return name.getFullName();
  }
  public void setName (Name name) {
    this.name = name;
  }
  public boolean equals (Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person)obj;
    return this.name.equals(other.name);
  }
  public String toString() {
    return name.getFirstName();
  }

}
