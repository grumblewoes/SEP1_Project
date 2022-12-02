package view.clubAssociate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BoardGamesModel;
import model.ClubAssociate;

import java.util.ArrayList;

public class ClubAssociateListViewModel
{
  private ObservableList<ClubAssociateViewModel> list;
  private BoardGamesModel model;


  public ClubAssociateListViewModel(BoardGamesModel model)
  {
    this.model=model;
    this.list = FXCollections.observableArrayList();
    update();
  }
  public ObservableList<ClubAssociateViewModel> getList() {
    return list;
  }

  public void update(){
    list.clear();
    ArrayList<ClubAssociate> clubAssociates = model.getAllClubAssociates();
    for (ClubAssociate clubAssociate : clubAssociates)
      list.add(new ClubAssociateViewModel(clubAssociate));
  }
  public void add(ClubAssociate clubAssociate) {
    list.add(new ClubAssociateViewModel(clubAssociate));

  }

}
