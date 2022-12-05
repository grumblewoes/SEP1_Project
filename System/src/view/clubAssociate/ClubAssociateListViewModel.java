package view.clubAssociate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.ClubAssociate;

import java.io.Serializable;
import java.util.ArrayList;

public class ClubAssociateListViewModel implements Serializable
{
  private ObservableList<ClubAssociateViewModel> list;
  private ObservableList<ClubAssociateViewModel> listOfMembers;
  private BoardGamesModel model;


  public ClubAssociateListViewModel(BoardGamesModel model)
  {
    this.model=model;
    this.list = FXCollections.observableArrayList();
    this.listOfMembers = FXCollections.observableArrayList();
    update();
    updateMembers();
  }
  public ObservableList<ClubAssociateViewModel> getList() {
    return list;
  }
  public ObservableList<ClubAssociateViewModel> getListOfMembers() {
    return listOfMembers;
  }
  public void update(){
    list.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for (ClubAssociate clubAssociate : clubAssociates)
      list.add(new ClubAssociateViewModel(clubAssociate));
  }
  public void updateMembers(){
    listOfMembers.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for(int i=0;i< clubAssociates.size();i++){
      if(clubAssociates.get(i).isMember()==true){
        listOfMembers.add(new ClubAssociateViewModel(clubAssociates.get(i)));
      }
    }
  }
  public void add(ClubAssociate clubAssociate) {
    list.add(new ClubAssociateViewModel(clubAssociate));
  }
}
