package model;

public abstract class Person
{
  private Name name;

  public Person(Name name) {
    this.name=name;
  }

  public String getFullName(){
    return name.getFullName();
  }

  public boolean equals (Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person other = (Person)obj;
    return this.name.equals(other.name);
  }
  public String toString() {
    return name.getFullName();
  }

}
