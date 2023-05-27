package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class System_Code extends Application {

	private static String dbUsername = "root"; // database username
	private static String dbPassword = "database"; // database password
	private static String URL = "127.0.0.1"; // server location
	private static String port = "3306"; // port that mysql uses
	private static String dbName = "Project"; // database on mysql to connect to

	private static Connection con;

	@FXML
	private Button DeleteBtn;

	@FXML
	private Button DeleteBtn1;

	@FXML
	private Button InsertBtn;

	@FXML
	private Button SelectBtn;

	@FXML
	private Button UpdateBtn;

	@FXML
	private Label errorLabel;

	String TableID;
	String TableName;
	String idd;
	String Insert;

/////////////////////////////////////////////////////////////////////////// Switch Tables /////////////////////////////////////////////////////////////////////////////

	@FXML
	MenuButton chooseTable;

	@FXML
	void openBatch(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/batchWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openProduct(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/productWindows.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openSales(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/salewindows.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openBrand(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/brandWindows.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openCompany(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/companyWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();
		// CompanySelectFunc(event);

	}

	@FXML
	void openShippingCompany(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/shippingCompWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openCustomer(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/customerWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openPackagingType(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/packagingWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openMeasurementUnit(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/measurementWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openHealthPermit(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/healthWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void openBatchContent(ActionEvent event) throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/batchConWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);

		stage1.show();

	}
	
	
	///////////////////////////////////////////////////////////////// BILL /////////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> billQtyListView;

	@FXML
	private ListView<String> billUnitsListView;

	@FXML
	private ListView<String> billDescListView;

	@FXML
	private TextField billCartxt;

	@FXML
	private TextField billDatetxt;

	@FXML
	private TextField billNumtxt;

	void printBill() throws SQLException, IOException {

		Stage stage1;
		Parent root;

		stage1 = (Stage) chooseTable.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("windows/billWindow.fxml"));

		Scene scene = new Scene(root);
		stage1.setScene(scene);
		stage1.show();

	}

	@FXML
	void printBillFunc(ActionEvent event) throws SQLException {

		ObservableList<String> billQtyItem = billQtyListView.getItems();
		ObservableList<String> billUnitItem = billUnitsListView.getItems();
		ObservableList<String> billDescItem = billDescListView.getItems();

		billQtyItem.setAll("");
		billUnitItem.setAll("");
		billDescItem.setAll("");

		billQtyItem.remove(0);
		billUnitItem.remove(0);
		billDescItem.remove(0);

		billQtyItem.addAll(quantity);
		billUnitItem.addAll(units);
		billDescItem.addAll(description);

		billCartxt.setText(car);
		billNumtxt.setText(num);
		billDatetxt.setText(date);
	}

//////////////////////////////////////////////////////////////////////// Tables functions: ///////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////// COMPANY /////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> cidListView;

	@FXML
	private ListView<String> cnameListView;

	@FXML
	private ListView<String> cAddressListView;

	@FXML
	private ListView<String> cCityListView;

	@FXML
	private ListView<String> cNumListView;

	@FXML
	private ListView<String> cEmailListView;

	@FXML
	private ListView<String> cPersonListView;

	@FXML
	private ListView<String> cCountryListView;

	@FXML
	private TextField Companynametxt;

	@FXML
	private TextField companyCountrytxt;

	@FXML
	private TextField CompanyCitytxt;

	@FXML
	private TextField CompanyAddresstxt;

	@FXML
	private TextField CompanyContactPtxt;

	@FXML
	private TextField CompanyEmailtxt;

	@FXML
	private TextField CompanyPhonenumtxt;

	@FXML
	ChoiceBox<Object> compIDBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> compNameBox = new ChoiceBox<Object>();

	ArrayList<String> compIDArray = new ArrayList<String>();

	ArrayList<String> compNameArray = new ArrayList<String>();

	String compName;
	String compID;

	@FXML
	void CompanyDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "Company";
		TableID = "CoID";
		idd = compID;

		Delete(idd, TableName, TableID);
		CompanySelectFunc(event);

		Companynametxt.setText("");
		companyCountrytxt.setText("");
		CompanyCitytxt.setText("");
		CompanyAddresstxt.setText("");
		CompanyContactPtxt.setText("");
		CompanyEmailtxt.setText("");
		CompanyPhonenumtxt.setText("");
	}

	@FXML
	void CompanyInsertFunc(ActionEvent event) throws SQLException {

		Insert = "INSERT INTO company (Coname, country, city, address, Ccontact_person, email, phone_number) "
				+ "VALUES ( '" + Companynametxt.getText() + "', '" + companyCountrytxt.getText() + "', '"
				+ CompanyCitytxt.getText() + "', '" + CompanyAddresstxt.getText() + "', '"
				+ CompanyContactPtxt.getText() + "', '" + CompanyEmailtxt.getText() + "', '"
				+ CompanyPhonenumtxt.getText() + "');";

		insert(Insert);
		CompanySelectFunc(event);

		Companynametxt.setText("");
		companyCountrytxt.setText("");
		CompanyCitytxt.setText("");
		CompanyAddresstxt.setText("");
		CompanyContactPtxt.setText("");
		CompanyEmailtxt.setText("");
		CompanyPhonenumtxt.setText("");

	}

	@FXML
	void CompanySelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> cIDItem = cidListView.getItems();
		ObservableList<String> cnameItem = cnameListView.getItems();
		ObservableList<String> cAddressItem = cAddressListView.getItems();
		ObservableList<String> cCityItem = cCityListView.getItems();
		ObservableList<String> cNumItem = cNumListView.getItems();
		ObservableList<String> cEmailItem = cEmailListView.getItems();
		ObservableList<String> cPersonItem = cPersonListView.getItems();
		ObservableList<String> cCountryItem = cCountryListView.getItems();

		cnameItem.setAll("");
		cIDItem.setAll("");
		cAddressItem.setAll("");
		cCityItem.setAll("");
		cNumItem.setAll("");
		cEmailItem.setAll("");
		cPersonItem.setAll("");
		cCountryItem.setAll("");

		cnameItem.remove(0);
		cIDItem.remove(0);
		cAddressItem.remove(0);
		cCityItem.remove(0);
		cNumItem.remove(0);
		cEmailItem.remove(0);
		cPersonItem.remove(0);
		cCountryItem.remove(0);

		compIDArray.clear();
		compNameArray.clear();

		PreparedStatement ps10 = con.prepareStatement("select Coname from Company;");
		ResultSet rs10 = ps10.executeQuery();

		while (rs10.next()) {
			compNameArray.add(rs10.getString(1));
			compNameBox.getItems().add(rs10.getString(1));
		}

		compNameBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					compName = compNameArray.get(new_val.intValue());
				});

		compNameBox = new ChoiceBox<Object>(FXCollections.observableArrayList(compNameArray));

		PreparedStatement ps11 = con.prepareStatement("select CoID from Company;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			compIDArray.add(rs11.getString(1));
			compIDBox.getItems().add(rs11.getString(1));
		}

		compIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					compID = compIDArray.get(new_val.intValue());
				});

		compIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(compIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from company;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			cIDItem.addAll(rs1.getString(1));

			cnameItem.addAll(rs1.getString(2));

			cCountryItem.addAll(rs1.getString(3));

			cCityItem.addAll(rs1.getString(4));

			cAddressItem.addAll(rs1.getString(5));

			cPersonItem.addAll(rs1.getString(6));

			cEmailItem.addAll(rs1.getString(7));

			cNumItem.addAll(rs1.getString(8));
		}
	}

	@FXML
	void CompanyUpdateFunc(ActionEvent event) throws SQLException {

		CompanyUpdate(compID, Companynametxt.getText(), companyCountrytxt.getText(), CompanyCitytxt.getText(),
				CompanyAddresstxt.getText(), CompanyContactPtxt.getText(), CompanyEmailtxt.getText(),
				CompanyPhonenumtxt.getText());

		CompanySelectFunc(event);

		Companynametxt.setText("");
		companyCountrytxt.setText("");
		CompanyCitytxt.setText("");
		CompanyAddresstxt.setText("");
		CompanyContactPtxt.setText("");
		CompanyEmailtxt.setText("");
		CompanyPhonenumtxt.setText("");
	}

	@FXML
	void CompanySearchFunc(ActionEvent event) throws SQLException {

		ObservableList<String> cIDItem = cidListView.getItems();
		ObservableList<String> cnameItem = cnameListView.getItems();
		ObservableList<String> cAddressItem = cAddressListView.getItems();
		ObservableList<String> cCityItem = cCityListView.getItems();
		ObservableList<String> cNumItem = cNumListView.getItems();
		ObservableList<String> cEmailItem = cEmailListView.getItems();
		ObservableList<String> cPersonItem = cPersonListView.getItems();
		ObservableList<String> cCountryItem = cCountryListView.getItems();

		cnameItem.setAll("");
		cIDItem.setAll("");
		cAddressItem.setAll("");
		cCityItem.setAll("");
		cNumItem.setAll("");
		cEmailItem.setAll("");
		cPersonItem.setAll("");
		cCountryItem.setAll("");

		cnameItem.remove(0);
		cIDItem.remove(0);
		cAddressItem.remove(0);
		cCityItem.remove(0);
		cNumItem.remove(0);
		cEmailItem.remove(0);
		cPersonItem.remove(0);
		cCountryItem.remove(0);

		compIDArray.clear();

		String cID = "";

		if (cusName != "") {

			String SQLtxt = "select CoID\r\n" + "from Company\r\n" + "where Coname = '" + compName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				cID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry company name not found...");
			}
		} else {
			errorLabel.setText("Please enter company name...");
		}

		PreparedStatement ps11 = con.prepareStatement("select CoID from Company;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			compIDArray.add(rs11.getString(1));
			compIDBox.getItems().add(rs11.getString(1));
		}

		compIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					compID = compIDArray.get(new_val.intValue());
				});

		compIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(compIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from company where coID = '" + cID + "';");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			cIDItem.addAll(rs1.getString(1));

			cnameItem.addAll(rs1.getString(2));

			cCountryItem.addAll(rs1.getString(3));

			cCityItem.addAll(rs1.getString(4));

			cAddressItem.addAll(rs1.getString(5));

			cPersonItem.addAll(rs1.getString(6));

			cEmailItem.addAll(rs1.getString(7));

			cNumItem.addAll(rs1.getString(8));
		}
	}

///////////////////////////////////////////////////////////////////////////////////// Shipping company /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> scIDListView;

	@FXML
	private ListView<String> scNameListView;

	@FXML
	private ListView<String> scCountryListView;

	@FXML
	private ListView<String> scNumListView;

	@FXML
	private ListView<String> scEmailListView;

	@FXML
	private ListView<String> scPersonListView;

	@FXML
	private TextField ShipingCompanyNametxt;

	@FXML
	private TextField ShipingCompanyCountrytxt;

	@FXML
	private TextField ShipingCompanyPhonenumtxt;

	@FXML
	private TextField ShipingCompanyEmailtxt;

	@FXML
	private TextField ShipingCompanyContactPtxt;

	@FXML
	ChoiceBox<Object> scompIDBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> scompNameBox = new ChoiceBox<Object>();

	ArrayList<String> scompIDArray = new ArrayList<String>();

	ArrayList<String> scompNameArray = new ArrayList<String>();

	String scompName;
	String scompID;

	@FXML
	void ShipingCompanyDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "shipping_company";
		TableID = "SID";
		idd = scompID;

		Delete(idd, TableName, TableID);
		ShipingCompanySelectFunc(event);

		ShipingCompanyNametxt.setText("");
		ShipingCompanyCountrytxt.setText("");
		ShipingCompanyPhonenumtxt.setText("");
		ShipingCompanyEmailtxt.setText("");
		ShipingCompanyContactPtxt.setText("");
	}

	@FXML
	void ShipingCompanyInsertFunc(ActionEvent event) throws SQLException {

		Insert = "INSERT INTO shipping_company (SCname, country, phone_number, email, SCcontact_person) " + "VALUES ( '"
				+ ShipingCompanyNametxt.getText() + "', '" + ShipingCompanyCountrytxt.getText() + "', '"
				+ ShipingCompanyPhonenumtxt.getText() + "', '" + ShipingCompanyEmailtxt.getText() + "', '"
				+ ShipingCompanyContactPtxt.getText() + "');";

		insert(Insert);
		ShipingCompanySelectFunc(event);

		ShipingCompanyNametxt.setText("");
		ShipingCompanyCountrytxt.setText("");
		ShipingCompanyPhonenumtxt.setText("");
		ShipingCompanyEmailtxt.setText("");
		ShipingCompanyContactPtxt.setText("");
	}

	@FXML
	void ShipingCompanySelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> scIDItem = scIDListView.getItems();
		ObservableList<String> scNameItem = scNameListView.getItems();
		ObservableList<String> scCountryItem = scCountryListView.getItems();
		ObservableList<String> scPersonItem = scPersonListView.getItems();
		ObservableList<String> scNumItem = scNumListView.getItems();
		ObservableList<String> scEmailItem = scEmailListView.getItems();

		scNameItem.setAll("");
		scIDItem.setAll("");
		scCountryItem.setAll("");
		scPersonItem.setAll("");
		scNumItem.setAll("");
		scEmailItem.setAll("");

		scNameItem.remove(0);
		scIDItem.remove(0);
		scCountryItem.remove(0);
		scPersonItem.remove(0);
		scNumItem.remove(0);
		scEmailItem.remove(0);

		scompNameArray.clear();

		PreparedStatement ps10 = con.prepareStatement("select Scname from shipping_company;");
		ResultSet rs10 = ps10.executeQuery();

		while (rs10.next()) {
			scompNameArray.add(rs10.getString(1));
			scompNameBox.getItems().add(rs10.getString(1));
		}

		scompNameBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					scompName = scompNameArray.get(new_val.intValue());
				});

		scompNameBox = new ChoiceBox<Object>(FXCollections.observableArrayList(scompNameArray));

		scompIDArray.clear();

		PreparedStatement ps11 = con.prepareStatement("select SID from shipping_company;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			scompIDArray.add(rs11.getString(1));
			scompIDBox.getItems().add(rs11.getString(1));
		}

		scompIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					scompID = scompIDArray.get(new_val.intValue());
				});

		scompIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(scompIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from shipping_company;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			scIDItem.addAll(rs1.getString(1));

			scNameItem.addAll(rs1.getString(2));

			scCountryItem.addAll(rs1.getString(3));

			scNumItem.addAll(rs1.getString(4));

			scEmailItem.addAll(rs1.getString(5));

			scPersonItem.addAll(rs1.getString(6));
		}

	}

	@FXML
	void ShipingCompanyUpdateFunc(ActionEvent event) throws SQLException {

		ShippingCompanyUpdate(scompID, ShipingCompanyNametxt.getText(), ShipingCompanyCountrytxt.getText(),
				ShipingCompanyPhonenumtxt.getText(), ShipingCompanyEmailtxt.getText(),
				ShipingCompanyContactPtxt.getText());

		ShipingCompanySelectFunc(event);

		ShipingCompanyNametxt.setText("");
		ShipingCompanyCountrytxt.setText("");
		ShipingCompanyPhonenumtxt.setText("");
		ShipingCompanyEmailtxt.setText("");
		ShipingCompanyContactPtxt.setText("");
	}

	@FXML
	void ShipingCompanySearchFunc(ActionEvent event) throws SQLException {

		ObservableList<String> scIDItem = scIDListView.getItems();
		ObservableList<String> scNameItem = scNameListView.getItems();
		ObservableList<String> scCountryItem = scCountryListView.getItems();
		ObservableList<String> scPersonItem = scPersonListView.getItems();
		ObservableList<String> scNumItem = scNumListView.getItems();
		ObservableList<String> scEmailItem = scEmailListView.getItems();

		scNameItem.setAll("");
		scIDItem.setAll("");
		scCountryItem.setAll("");
		scPersonItem.setAll("");
		scNumItem.setAll("");
		scEmailItem.setAll("");

		scNameItem.remove(0);
		scIDItem.remove(0);
		scCountryItem.remove(0);
		scPersonItem.remove(0);
		scNumItem.remove(0);
		scEmailItem.remove(0);

		String scID = "";

		if (scompName != "") {

			String SQLtxt = "select SID\r\n" + "from shipping_company\r\n" + "where SCname = '" + scompName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				scID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry company name not found...");
			}
		} else {
			errorLabel.setText("Please enter company name...");
		}

		scompIDArray.clear();

		PreparedStatement ps11 = con.prepareStatement("select SID from shipping_company;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			scompIDArray.add(rs11.getString(1));
			scompIDBox.getItems().add(rs11.getString(1));
		}

		scompIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					scompID = scompIDArray.get(new_val.intValue());
				});

		scompIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(scompIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from shipping_company where SID = '" + scID + "';");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			scIDItem.addAll(rs1.getString(1));

			scNameItem.addAll(rs1.getString(2));

			scCountryItem.addAll(rs1.getString(3));

			scNumItem.addAll(rs1.getString(4));

			scEmailItem.addAll(rs1.getString(5));

			scPersonItem.addAll(rs1.getString(6));
		}

	}

///////////////////////////////////////////////////////////////////////////////////// Batch /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> baIDListView;

	@FXML
	private ListView<String> baCoIDListView;

	@FXML
	private ListView<String> baSIDListView;

	@FXML
	private ListView<String> baSizeListView;

	@FXML
	private ListView<String> baCuBrokerListView;

	@FXML
	private ListView<String> baArrivaleListView;

	@FXML
	private ListView<String> bcNameListView;

	@FXML
	private ListView<String> bscNameListView;

	@FXML
	private TextField BatchIDtxt;

	@FXML
	private TextField BatchSizetxt;

	@FXML
	private TextField BatchCustBrokertxt;

	@FXML
	private TextField BatchArrivalDatetxt;

	@FXML
	ChoiceBox<Object> batchSCompBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> batchCompBox = new ChoiceBox<Object>();

	ArrayList<String> batchSCompArray = new ArrayList<String>();

	ArrayList<String> batchCompArray = new ArrayList<String>();

	String batchSCompName;

	String batchCompName;

	@FXML
	void BatchDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "Batch";
		TableID = "Baid";
		idd = BatchIDtxt.getText();

		Statement stmt = con.createStatement();
		String baID = "select baid from batch_content;";
		ResultSet rs1 = stmt.executeQuery(baID);

		String h = null;
		while (rs1.next()) {
			h = rs1.getString(1);

			if (h.equals(idd)) {

				errorLabel.setText("Sorry, but this id is used in another table.");
				break;
			}
		}

		if (!h.equals(idd)) {

			Delete(idd, TableName, TableID);
			BatchSelectFunc(event);

			BatchIDtxt.setText("");
			BatchSizetxt.setText("");
			BatchCustBrokertxt.setText("");
			BatchArrivalDatetxt.setText("");
		}
	}

	@FXML
	void BatchInsertFunc(ActionEvent event) throws SQLException {
		// READ THE NAME THEN GET THE ID

		String compID = null;
		String scID = null;

		String SQLtxt = "select CoID\r\n" + "from company\r\n" + "where Coname = '" + batchCompName + "';";

		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery(SQLtxt);

		String SQLtxt1 = "select SID\r\n" + "from shipping_company\r\n" + "where SCname = '" + batchSCompName + "';";

		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(SQLtxt1);

		if (rs1.next()) {
			compID = rs1.getString(1);

			if (rs.next()) {

				scID = rs.getString(1);

				Insert = "INSERT INTO Batch (Baid, CoID, SID, size, customer_broker, arrival_date) " + "VALUES ( '"
						+ BatchIDtxt.getText() + "', '" + compID + "', '" + scID + "', '" + BatchSizetxt.getText()
						+ "', '" + BatchCustBrokertxt.getText() + "', '" + BatchArrivalDatetxt.getText() + "');";

				insert(Insert);
				BatchSelectFunc(event);

				BatchIDtxt.setText("");
				BatchSizetxt.setText("");
				BatchCustBrokertxt.setText("");
				BatchArrivalDatetxt.setText("");

			} else {
				errorLabel.setText("Sorry, shipping company name not found...");
			}
		}

		else {
			errorLabel.setText("Sorry, company name not found...");
		}
	}

	@FXML
	void BatchSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> baIDItem = baIDListView.getItems();
		ObservableList<String> baSizeItem = baSizeListView.getItems();
		ObservableList<String> baBrokerItem = baCuBrokerListView.getItems();
		ObservableList<String> baArrivalItem = baArrivaleListView.getItems();

		ObservableList<String> bcnameItem = bcNameListView.getItems();
		ObservableList<String> bscnameItem = bscNameListView.getItems();

		ObservableList<String> cNameItem = cnameListView.getItems();
		ObservableList<String> cNumItem = cNumListView.getItems();
		ObservableList<String> cEmailItem = cEmailListView.getItems();
		ObservableList<String> cCountryItem = cCountryListView.getItems();
		ObservableList<String> cPersonItem = cPersonListView.getItems();

		ObservableList<String> scNameItem = scNameListView.getItems();
		ObservableList<String> scCountryItem = scCountryListView.getItems();
		ObservableList<String> scNumItem = scNumListView.getItems();
		ObservableList<String> scEmailItem = scEmailListView.getItems();
		ObservableList<String> scPersonItem = scPersonListView.getItems();

		baIDItem.setAll("");
		baSizeItem.setAll("");
		baBrokerItem.setAll("");
		baArrivalItem.setAll("");

		bcnameItem.setAll("");
		bscnameItem.setAll("");

		cNameItem.setAll("");
		cNumItem.setAll("");
		cEmailItem.setAll("");
		cCountryItem.setAll("");
		cPersonItem.setAll("");

		scNameItem.setAll("");
		scCountryItem.setAll("");
		scPersonItem.setAll("");
		scNumItem.setAll("");
		scEmailItem.setAll("");

		baIDItem.remove(0);
		baSizeItem.remove(0);
		baBrokerItem.remove(0);
		baArrivalItem.remove(0);

		bcnameItem.remove(0);
		bscnameItem.remove(0);

		cNameItem.remove(0);
		cNumItem.remove(0);
		cEmailItem.remove(0);
		cCountryItem.remove(0);
		cPersonItem.remove(0);

		scNameItem.remove(0);
		scCountryItem.remove(0);
		scPersonItem.remove(0);
		scNumItem.remove(0);
		scEmailItem.remove(0);

		batchSCompArray.clear();
		batchCompArray.clear();

		PreparedStatement ps = con.prepareStatement("select Coname from company");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			batchCompArray.add(rs.getString(1));
			batchCompBox.getItems().add(rs.getString(1));

			bcnameItem.addAll(rs.getString(1));
		}

		batchCompBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					batchCompName = batchCompArray.get(new_val.intValue());

				});
		batchCompBox = new ChoiceBox<Object>(FXCollections.observableArrayList(batchCompArray));

		PreparedStatement ps1 = con.prepareStatement("select SCname from shipping_company");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			batchSCompArray.add(rs1.getString(1));
			batchSCompBox.getItems().add(rs1.getString(1));

			bscnameItem.addAll(rs1.getString(1));
		}

		batchSCompBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					batchSCompName = batchSCompArray.get(new_val.intValue());

				});
		batchSCompBox = new ChoiceBox<Object>(FXCollections.observableArrayList(batchSCompArray));

		String SQLtxt = "select distinct b.Baid, c.Coname, s.SCname, b.size, b.customer_broker, b.arrival_date,\r\n"
				+ "c.country, c.Ccontact_person, c.email, c.phone_number,	\r\n"
				+ "s.country, s.phone_number, s.email, s.SCcontact_person\r\n"
				+ "from Batch b, company c, shipping_company s\r\n" + "where b.CoID = c.CoID\r\n"
				+ "and b.SID = s.SID;";

		PreparedStatement ps11 = con.prepareStatement(SQLtxt);

		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {

			baIDItem.addAll(rs11.getString(1));
			cNameItem.addAll(rs11.getString(2));
			scNameItem.addAll(rs11.getString(3));

			baSizeItem.addAll(rs11.getString(4));
			baBrokerItem.addAll(rs11.getString(5));
			baArrivalItem.addAll(rs11.getString(6));

			cCountryItem.addAll(rs11.getString(7));
			cPersonItem.addAll(rs11.getString(8));
			cEmailItem.addAll(rs11.getString(9));
			cNumItem.addAll(rs11.getString(10));

			scCountryItem.addAll(rs11.getString(11));
			scNumItem.addAll(rs11.getString(12));
			scEmailItem.addAll(rs11.getString(13));
			scPersonItem.addAll(rs11.getString(14));
		}
	}

	@FXML
	void BatchUpdateFunc(ActionEvent event) throws SQLException {
		// READ THE NAME THEN GET THE ID FOR THE FORIEGN KEY

		String compID = "";
		if (batchCompName != "") {

			String SQLtxt = "select CoID\r\n" + "from company\r\n" + "where Coname = '" + batchCompName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				compID = rs1.getString(1);
			}
		}

		String sCompID = "";

		if (batchSCompName != "") {

			String SQLtxt = "select SID\r\n" + "from shipping_company\r\n" + "where SCname = '" + batchSCompName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				sCompID = rs1.getString(1);
			}
		}

		BatchUpdate(BatchIDtxt.getText(), compID, sCompID, BatchSizetxt.getText(), BatchCustBrokertxt.getText(),
				BatchArrivalDatetxt.getText());
		BatchSelectFunc(event);

		BatchIDtxt.setText("");
		BatchSizetxt.setText("");
		BatchCustBrokertxt.setText("");
		BatchArrivalDatetxt.setText("");
	}

///////////////////////////////////////////////////////////////////////////////////// Customer /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> cuIDListView;

	@FXML
	private ListView<String> cuNameListView;

	@FXML
	private ListView<String> cuAddressListView;

	@FXML
	private ListView<String> cuNumListView;

	@FXML
	private ListView<String> cuTypeListView;

	@FXML
	private ListView<String> cuFirstSaleListView;

	@FXML
	private TextField Customernametxt;

	@FXML
	private TextField CustomerPhonenumtxt;

	@FXML
	private TextField CustomerAddresstxt;

	@FXML
	private TextField CustomerTypetxt;

	@FXML
	private TextField CustomerFistSaleDatetxt;

	@FXML
	ChoiceBox<Object> cusIDBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> cusNameBox = new ChoiceBox<Object>();

	ArrayList<String> cusIDArray = new ArrayList<String>();

	ArrayList<String> cusNameArray = new ArrayList<String>();

	String cusName;
	String cusID;

	@FXML
	void CustomerDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "Customer";
		TableID = "CuID";
		idd = cusID;

		Delete(idd, TableName, TableID);
		CustomerSelectFunc(event);

		Customernametxt.setText("");
		CustomerPhonenumtxt.setText("");
		CustomerAddresstxt.setText("");
		CustomerTypetxt.setText("");
		CustomerFistSaleDatetxt.setText("");
	}

	@FXML
	void CustomerInsertFunc(ActionEvent event) throws SQLException {

		Insert = "INSERT INTO Customer (Cname, phone_number, Address, CuType, FirstSaleDate) " + " VALUES ( '"
				+ Customernametxt.getText() + "', '" + CustomerPhonenumtxt.getText() + "', '"
				+ CustomerAddresstxt.getText() + "', '" + CustomerTypetxt.getText() + "', '"
				+ CustomerFistSaleDatetxt.getText() + "');";

		insert(Insert);
		CustomerSelectFunc(event);

		Customernametxt.setText("");
		CustomerPhonenumtxt.setText("");
		CustomerAddresstxt.setText("");
		CustomerTypetxt.setText("");
		CustomerFistSaleDatetxt.setText("");

	}

	@FXML
	void CustomerSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> cuIDItem = cuIDListView.getItems();
		ObservableList<String> cuNameItem = cuNameListView.getItems();
		ObservableList<String> cuAddressItem = cuAddressListView.getItems();
		ObservableList<String> cuNumItem = cuNumListView.getItems();
		ObservableList<String> cuTypeItem = cuTypeListView.getItems();
		ObservableList<String> cuFirstSaleItem = cuFirstSaleListView.getItems();

		cuNameItem.setAll("");
		cuIDItem.setAll("");
		cuAddressItem.setAll("");
		cuTypeItem.setAll("");
		cuNumItem.setAll("");
		cuFirstSaleItem.setAll("");

		cuNameItem.remove(0);
		cuIDItem.remove(0);
		cuAddressItem.remove(0);
		cuTypeItem.remove(0);
		cuNumItem.remove(0);
		cuFirstSaleItem.remove(0);

		cusNameArray.clear();
		cusIDArray.clear();

		PreparedStatement ps10 = con.prepareStatement("select Cname from Customer;");
		ResultSet rs10 = ps10.executeQuery();

		while (rs10.next()) {

			cusNameArray.add(rs10.getString(1));
			cusNameBox.getItems().add(rs10.getString(1));

		}

		cusNameBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					cusName = cusNameArray.get(new_val.intValue());
				});

		cusNameBox = new ChoiceBox<Object>(FXCollections.observableArrayList(cusNameArray));

		PreparedStatement ps11 = con.prepareStatement("select CuID from customer;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			cusIDArray.add(rs11.getString(1));
			cusIDBox.getItems().add(rs11.getString(1));
		}

		cusIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					cusID = cusIDArray.get(new_val.intValue());
				});

		cusIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(cusIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from Customer;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			cuIDItem.addAll(rs1.getString(1));

			cuNameItem.addAll(rs1.getString(2));

			cuNumItem.addAll(rs1.getString(3));

			cuAddressItem.addAll(rs1.getString(4));

			cuTypeItem.addAll(rs1.getString(5));

			cuFirstSaleItem.addAll(rs1.getString(6));
		}
	}

	@FXML
	void CustomerUpdateFunc(ActionEvent event) throws SQLException {

		CustomerUpdate(cusID, Customernametxt.getText(), CustomerPhonenumtxt.getText(), CustomerAddresstxt.getText(),
				CustomerTypetxt.getText(), CustomerFistSaleDatetxt.getText());
		CustomerSelectFunc(event);

		Customernametxt.setText("");
		CustomerPhonenumtxt.setText("");
		CustomerAddresstxt.setText("");
		CustomerTypetxt.setText("");
		CustomerFistSaleDatetxt.setText("");
	}

	@FXML
	void CustomerSearchFunc(ActionEvent event) throws SQLException {

		ObservableList<String> cuIDItem = cuIDListView.getItems();
		ObservableList<String> cuNameItem = cuNameListView.getItems();
		ObservableList<String> cuAddressItem = cuAddressListView.getItems();
		ObservableList<String> cuNumItem = cuNumListView.getItems();
		ObservableList<String> cuTypeItem = cuTypeListView.getItems();
		ObservableList<String> cuFirstSaleItem = cuFirstSaleListView.getItems();

		cuNameItem.setAll("");
		cuIDItem.setAll("");
		cuAddressItem.setAll("");
		cuTypeItem.setAll("");
		cuNumItem.setAll("");
		cuFirstSaleItem.setAll("");

		cuNameItem.remove(0);
		cuIDItem.remove(0);
		cuAddressItem.remove(0);
		cuTypeItem.remove(0);
		cuNumItem.remove(0);
		cuFirstSaleItem.remove(0);

		String cID = "";

		if (cusName != "") {

			String SQLtxt = "select CuID\r\n" + "from Customer\r\n" + "where Cname = '" + cusName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				cID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry customer name not found...");
			}
		} else {
			errorLabel.setText("Please enter customer name...");
		}

		PreparedStatement ps11 = con.prepareStatement("select CuID from customer;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			cusIDArray.add(rs11.getString(1));
			cusIDBox.getItems().add(rs11.getString(1));
		}

		cusIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					cusID = cusIDArray.get(new_val.intValue());
				});

		cusIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(cusIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from Customer where CuID = '" + cID + "';");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			cuIDItem.addAll(rs1.getString(1));

			cuNameItem.addAll(rs1.getString(2));

			cuNumItem.addAll(rs1.getString(3));

			cuAddressItem.addAll(rs1.getString(4));

			cuTypeItem.addAll(rs1.getString(5));

			cuFirstSaleItem.addAll(rs1.getString(6));
		}
	}

///////////////////////////////////////////////////////////////////////////////////// Brand /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> bidListView;

	@FXML
	private ListView<String> bcnameListView;

	@FXML
	private ListView<String> bnameListView;

	@FXML
	private TextField BrandNametxt;

	@FXML
	ChoiceBox<Object> brandCompBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> brandIDBox = new ChoiceBox<Object>();

	ArrayList<String> brandIDArray = new ArrayList<String>();

	ArrayList<String> brandCompArray = new ArrayList<String>();

	String brandCompName;
	String brandID;

	@FXML
	void BrandDeleteFunc(ActionEvent event) throws SQLException, IOException {

		TableName = "brand";
		TableID = "BID";
		idd = brandID;

		Statement stmt = con.createStatement();
		String baID = "select Brid from product;";
		ResultSet rs1 = stmt.executeQuery(baID);

		String id = null;

		while (rs1.next()) {
			id = rs1.getString(1);

			if (id.equals(idd)) {
				errorLabel.setText("Sorry, but this id is used in another table.");
				break;
			}
		}

		if (!id.equals(idd)) {
			Delete(idd, TableName, TableID);
			BrandSelectFunc(event);

			BrandNametxt.setText("");
		}
	}

	@FXML
	void BrandInsertFunc(ActionEvent event) throws SQLException {

		String SQLtxt = "select CoID\r\n" + "from company\r\n" + "where Coname = '" + brandCompName + "';";

		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery(SQLtxt);

		String compID = null;

		if (rs1.next()) {
			compID = rs1.getString(1);
			Insert = "insert into brand (CoID, Bname) values (" + compID + ", '" + BrandNametxt.getText() + "');";

			insert(Insert);
		}

		else {
			errorLabel.setText("Sorry, company name not found...");
		}

		BrandSelectFunc(event);

		BrandNametxt.setText("");
	}

	@FXML
	void BrandSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> bidItem = bidListView.getItems();
		ObservableList<String> bcnameItem = bcnameListView.getItems();
		ObservableList<String> bnameItem = bnameListView.getItems();

		ObservableList<String> cnameItem = cnameListView.getItems();
		ObservableList<String> cAddressItem = cAddressListView.getItems();
		ObservableList<String> cCityItem = cCityListView.getItems();
		ObservableList<String> cNumItem = cNumListView.getItems();
		ObservableList<String> cEmailItem = cEmailListView.getItems();
		ObservableList<String> cPersonItem = cPersonListView.getItems();
		ObservableList<String> cCountryItem = cCountryListView.getItems();

		cnameItem.setAll("");
		bidItem.setAll("");
		bcnameItem.setAll("");
		bnameItem.setAll("");

		cAddressItem.setAll("");
		cCityItem.setAll("");
		cNumItem.setAll("");
		cEmailItem.setAll("");
		cPersonItem.setAll("");
		cCountryItem.setAll("");

		cnameItem.remove(0);
		bidItem.remove(0);
		bcnameItem.remove(0);
		bnameItem.remove(0);

		cAddressItem.remove(0);
		cCityItem.remove(0);
		cNumItem.remove(0);
		cEmailItem.remove(0);
		cPersonItem.remove(0);
		cCountryItem.remove(0);

		PreparedStatement ps11 = con.prepareStatement("select bid from brand;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			brandIDArray.add(rs11.getString(1));
			brandIDBox.getItems().add(rs11.getString(1));
		}

		brandIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					brandID = brandIDArray.get(new_val.intValue());
				});

		brandIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(brandIDArray));

		PreparedStatement ps = con.prepareStatement("select Coname from company");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			brandCompArray.add(rs.getString(1));
			brandCompBox.getItems().add(rs.getString(1));

			cnameItem.addAll(rs.getString(1));
		}

		brandCompBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					brandCompName = brandCompArray.get(new_val.intValue());
				});
		brandCompBox = new ChoiceBox<Object>(FXCollections.observableArrayList(brandCompArray));

		PreparedStatement ps1 = con.prepareStatement("select b.BID, b.Bname, \r\n"
				+ "c.Coname, c. country, c.city, c.address, c.Ccontact_person, c.email, c.phone_number\r\n"
				+ "from brand b, company c\r\n" + "where b.CoID = c.CoID;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			bidItem.addAll(rs1.getString(1));

			bnameItem.addAll(rs1.getString(2));

			bcnameItem.addAll(rs1.getString(3));

			cCountryItem.addAll(rs1.getString(4));

			cCityItem.addAll(rs1.getString(5));

			cAddressItem.addAll(rs1.getString(6));

			cPersonItem.addAll(rs1.getString(7));

			cEmailItem.addAll(rs1.getString(8));

			cNumItem.addAll(rs1.getString(9));
		}
	}

	@FXML
	void BrandUpdateFunc(ActionEvent event) throws SQLException {

		idd = brandID;
		String compID = "";

		if (brandCompName != "") {

			String SQLtxt = "select CoID\r\n" + "from company\r\n" + "where Coname = '" + brandCompName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			while (rs1.next()) {
				compID = rs1.getString(1);
			}
		}

		brandUpdate(brandID, compID, BrandNametxt.getText());

		BrandSelectFunc(event);
	}

///////////////////////////////////////////////////////////////////////////////////// Health permit /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> hIDListView;

	@FXML
	private ListView<String> hIssueDateListView;

	@FXML
	private ListView<String> hExpireDateListView;

	@FXML
	private TextField healthPermitIDtxt;

	@FXML
	private TextField healthPermitIssueDatetxt;

	@FXML
	private TextField healthPermitExpireDatetxt;

	@FXML
	void healthPermitDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "health_permit";
		TableID = "HID";
		idd = healthPermitIDtxt.getText();

		Delete(idd, TableName, TableID);
		healthPermitSelectFunc(event);

		healthPermitIDtxt.setText("");
	}

	@FXML
	void healthPermitInsertFunc(ActionEvent event) throws SQLException {

		Insert = "insert into health_permit (HID, date_of_issue, expire_date)\r\n" + "values ( '"
				+ healthPermitIDtxt.getText() + "', '" + healthPermitIssueDatetxt.getText() + "', '"
				+ healthPermitExpireDatetxt.getText() + "');";

		insert(Insert);
		healthPermitSelectFunc(event);

		healthPermitIDtxt.setText("");
	}

	@FXML
	void healthPermitSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> hIDItem = hIDListView.getItems();
		ObservableList<String> hIssueDateItem = hIssueDateListView.getItems();
		ObservableList<String> hExpireItem = hExpireDateListView.getItems();

		hIDItem.setAll("");
		hIssueDateItem.setAll("");
		hExpireItem.setAll("");

		hIDItem.remove(0);
		hIssueDateItem.remove(0);
		hExpireItem.remove(0);

		PreparedStatement ps1 = con.prepareStatement("select * from health_permit;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			hIDItem.addAll(rs1.getString(1));

			hIssueDateItem.addAll(rs1.getString(2));

			hExpireItem.addAll(rs1.getString(3));
		}
	}

	@FXML
	void healthPermitUpdateFunc(ActionEvent event) throws SQLException {

		healthPermitUpdate(healthPermitIDtxt.getText(), healthPermitIssueDatetxt.getText(),
				healthPermitExpireDatetxt.getText());
		healthPermitSelectFunc(event);

		healthPermitIDtxt.setText("");
	}

///////////////////////////////////////////////////////////////////////////////// Measurement unit /////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> mIDListView;

	@FXML
	private ListView<String> mNameListView;

	@FXML
	private TextField measurementUnitNametxt;

	@FXML
	ChoiceBox<Object> mUnitIDBox = new ChoiceBox<Object>();

	ArrayList<String> mUnitIDArray = new ArrayList<String>();

	String mUnitID;

	@FXML
	void measurementUnitDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "measurement_unit";
		TableID = "MuID";
		idd = mUnitID;

		Delete(idd, TableName, TableID);
		measurementUnitSelectFunc(event);

		measurementUnitNametxt.setText("");
	}

	@FXML
	void measurementUnitInsertFunc(ActionEvent event) throws SQLException {

		Insert = "insert into measurement_unit (Mname)\r\n values ( '" + measurementUnitNametxt.getText() + "');";

		insert(Insert);
		measurementUnitSelectFunc(event);

		measurementUnitNametxt.setText("");
	}

	@FXML
	void measurementUnitSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> mIDItem = mIDListView.getItems();
		ObservableList<String> mNameItem = mNameListView.getItems();

		mIDItem.setAll("");
		mNameItem.setAll("");

		mIDItem.remove(0);
		mNameItem.remove(0);

		PreparedStatement ps11 = con.prepareStatement("select MuID from measurement_unit;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			mUnitIDArray.add(rs11.getString(1));
			mUnitIDBox.getItems().add(rs11.getString(1));
		}

		mUnitIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					mUnitID = mUnitIDArray.get(new_val.intValue());
				});

		mUnitIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(mUnitIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from measurement_unit;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			mIDItem.addAll(rs1.getString(1));

			mNameItem.addAll(rs1.getString(2));
		}
	}

	@FXML
	void measurementUnitUpdateFunc(ActionEvent event) throws SQLException {

		measurementUnitUpdate(mUnitID, measurementUnitNametxt.getText());
		measurementUnitSelectFunc(event);

		measurementUnitNametxt.setText("");
	}

///////////////////////////////////////////////////////////////////////////////// Packaging type /////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> paIDListView;

	@FXML
	private ListView<String> paNameListView;

	@FXML
	private TextField packagingTypeNametxt;

	@FXML
	ChoiceBox<Object> pTypeIDBox = new ChoiceBox<Object>();

	ArrayList<String> pTypeIDArray = new ArrayList<String>();

	String pTypeID;

	@FXML
	void packagingTypeDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "packaging_type";
		TableID = "PaID";
		idd = pTypeID;

		Delete(idd, TableName, TableID);
		packagingTypeSelectFunc(event);

		packagingTypeNametxt.setText("");
	}

	@FXML
	void packagingTypeInsertFunc(ActionEvent event) throws SQLException {

		Insert = "insert into packaging_type (Pname)\r\n" + "values ( '" + packagingTypeNametxt.getText() + "');";

		insert(Insert);
		packagingTypeSelectFunc(event);

		packagingTypeNametxt.setText("");
	}

	@FXML
	void packagingTypeSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> paIDItem = paIDListView.getItems();
		ObservableList<String> paNameItem = paNameListView.getItems();

		paIDItem.setAll("");
		paNameItem.setAll("");

		paIDItem.remove(0);
		paNameItem.remove(0);

		PreparedStatement ps11 = con.prepareStatement("select PaID from packaging_type;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {
			pTypeIDArray.add(rs11.getString(1));
			pTypeIDBox.getItems().add(rs11.getString(1));
		}

		pTypeIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					pTypeID = pTypeIDArray.get(new_val.intValue());
				});

		pTypeIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(pTypeIDArray));

		PreparedStatement ps1 = con.prepareStatement("select * from packaging_type;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			paIDItem.addAll(rs1.getString(1));

			paNameItem.addAll(rs1.getString(2));
		}
	}

	@FXML
	void packagingTypeUpdateFunc(ActionEvent event) throws SQLException {

		packagingTypeUpdate(pTypeID, packagingTypeNametxt.getText());
		packagingTypeSelectFunc(event);

		packagingTypeNametxt.setText("");
	}

///////////////////////////////////////////////////////////////////////////////////// PRODUCT ////////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> prIDListView;

	@FXML
	private ListView<String> prBatchNameListView;

	@FXML
	private ListView<String> prNameListView;

	@FXML
	private ListView<String> prBarcodeListView;

	@FXML
	private ListView<String> prDescListView;

	@FXML
	private ListView<String> prSizeListView;

	@FXML
	private ListView<String> prMunameListView;

	@FXML
	private ListView<String> prPanameListView;

	@FXML
	private ListView<String> prHIDListView;

	@FXML
	private ListView<String> prUnitsListView;

	@FXML
	private ListView<String> prHSCodeListView;

	@FXML
	private ListView<String> prtaxListView;

	@FXML
	private TextField productNametxt;

	// @FXML
	// private TextField productBrandIDtxt;

	@FXML
	private TextField productBarCodetxt;

	@FXML
	private TextField productDescriptiontxt;

	@FXML
	private TextField productSizetxt;

	@FXML
	private TextField productNumperOfUnitstxt;

	@FXML
	private TextField productHSCodetxt;

	@FXML
	private TextField productTaxtxt;

	@FXML
	ChoiceBox<Object> proMUnitBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> proPTypeBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> proHpremitBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> proBrandBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> proIDBox = new ChoiceBox<Object>();

	ArrayList<String> proMUnitArray = new ArrayList<String>();

	ArrayList<String> proPTypeArray = new ArrayList<String>();

	ArrayList<String> proHpremitArray = new ArrayList<String>();

	ArrayList<String> proBrandArray = new ArrayList<String>();

	ArrayList<String> proIDArray = new ArrayList<String>();

	String proID;
	String proMUnit;
	String proPType;
	String proHpremit;
	String proBrand;

	@FXML
	void productDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "product";
		TableID = "PrID";
		idd = proID;

		Delete(idd, TableName, TableID);
		productSelectFunc(event);

		productNametxt.setText("");
		productBarCodetxt.setText("");
		productDescriptiontxt.setText("");
		productSizetxt.setText("");
		productNumperOfUnitstxt.setText("");
		productHSCodetxt.setText("");
		productTaxtxt.setText("");

		proMUnitBox.getSelectionModel().clearSelection();
		proPTypeBox.getSelectionModel().clearSelection();
		proHpremitBox.getSelectionModel().clearSelection();
		proBrandBox.getSelectionModel().clearSelection();
		proIDBox.getSelectionModel().clearSelection();

	}

	@FXML
	void productInsertFunc(ActionEvent event) throws SQLException {
		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID

		String mID = null, paID = null, bID = null, hid = null;

		System.out.println(proBrand);
		String SQLtxt = "select BID\r\n" + "from brand\r\n" + "where Bname = '" + proBrand + "';";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQLtxt);

		if (rs.next()) {
			bID = rs.getString(1);

			System.out.println(proMUnit);
			String SQLtxt1 = "select MuID\r\n" + "from measurement_unit\r\n" + "where Mname = '" + proMUnit + "';";

			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(SQLtxt1);

			if (rs1.next()) {
				mID = rs1.getString(1);

				System.out.println(proPType);
				String SQLtxt2 = "select PaID\r\n" + "from packaging_type\r\n" + "where Pname = '" + proPType + "';";

				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(SQLtxt2);

				if (rs2.next()) {
					paID = rs2.getString(1);

					String SQLtxt3 = "select HID\r\n" + "from health_permit\r\n" + "where HID = '" + proHpremit + "';";

					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery(SQLtxt3);

					if (rs3.next()) {
						hid = rs3.getString(1);

						String insert = "insert into product (Pname, Brid, barcode, description, size, MuID, PaID, HID, \r\n"
								+ "number_of_units, HS_code, custom_tax_tariff) \r\n" + "values ('"
								+ productNametxt.getText() + "', '" + bID + "', '" + productBarCodetxt.getText()
								+ "', '" + productDescriptiontxt.getText() + "', '" + productSizetxt.getText() + "', '"
								+ mID + "', '" + paID + "', '" + hid + "', '" + productNumperOfUnitstxt.getText()
								+ "', '" + productHSCodetxt.getText() + "', '" + productTaxtxt.getText() + "');";

						insert(insert);
						productSelectFunc(event);

						productNametxt.setText("");
						productBarCodetxt.setText("");
						productDescriptiontxt.setText("");
						productSizetxt.setText("");
						productNumperOfUnitstxt.setText("");
						productHSCodetxt.setText("");
						productTaxtxt.setText("");

						proMUnitBox.getSelectionModel().clearSelection();
						proPTypeBox.getSelectionModel().clearSelection();
						proHpremitBox.getSelectionModel().clearSelection();
						proBrandBox.getSelectionModel().clearSelection();
						proIDBox.getSelectionModel().clearSelection();
					}

				} else {
					errorLabel.setText("Sorry packaging type not found...");
				}
			} else {
				errorLabel.setText("Sorry measurement unit not found...");
			}
		} else {
			errorLabel.setText("Sorry brand name not found...");
		}
	}

	@FXML
	void productSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> prIDItem = prIDListView.getItems();
		ObservableList<String> prBNameItem = prBatchNameListView.getItems();
		ObservableList<String> pNameItem = prNameListView.getItems();
		ObservableList<String> prBarcodeItem = prBarcodeListView.getItems();
		ObservableList<String> prDescItem = prDescListView.getItems();
		ObservableList<String> prSizeItem = prSizeListView.getItems();
		ObservableList<String> prUnitsItem = prUnitsListView.getItems();
		ObservableList<String> prHSCodeItem = prHSCodeListView.getItems();
		ObservableList<String> prTaxItem = prtaxListView.getItems();

		ObservableList<String> paNameItem = paNameListView.getItems();
		ObservableList<String> mNameItem = mNameListView.getItems();
		ObservableList<String> hIssueItem = hIssueDateListView.getItems();
		ObservableList<String> hExpireItem = hExpireDateListView.getItems();

		ObservableList<String> prMNameItem = prMunameListView.getItems();
		ObservableList<String> prPaNameItem = prPanameListView.getItems();
		ObservableList<String> prHIDtem = prHIDListView.getItems();
		ObservableList<String> bNameItem = bnameListView.getItems();

		prIDItem.setAll("");
		prBNameItem.setAll("");
		pNameItem.setAll("");
		prBarcodeItem.setAll("");
		prDescItem.setAll("");
		prSizeItem.setAll("");
		prUnitsItem.setAll("");
		prHSCodeItem.setAll("");
		prTaxItem.setAll("");

		paNameItem.setAll("");
		mNameItem.setAll("");
		hIssueItem.setAll("");
		hExpireItem.setAll("");

		prMNameItem.setAll("");
		prPaNameItem.setAll("");
		prHIDtem.setAll("");
		bNameItem.setAll("");

		prIDItem.remove(0);
		prBNameItem.remove(0);
		pNameItem.remove(0);
		prBarcodeItem.remove(0);
		prDescItem.remove(0);
		prSizeItem.remove(0);
		prUnitsItem.remove(0);
		prHSCodeItem.remove(0);
		prTaxItem.remove(0);

		paNameItem.remove(0);
		mNameItem.remove(0);
		hIssueItem.remove(0);
		hExpireItem.remove(0);

		prMNameItem.remove(0);
		prPaNameItem.remove(0);
		prHIDtem.remove(0);
		bNameItem.remove(0);

		PreparedStatement ps11 = con.prepareStatement("select PrID from product;");
		ResultSet rs11 = ps11.executeQuery();

		while (rs11.next()) {

			proIDArray.add(rs11.getString(1));
			proIDBox.getItems().add(rs11.getString(1));
		}

		proIDBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					proID = proIDArray.get(new_val.intValue());
				});

		proIDBox = new ChoiceBox<Object>(FXCollections.observableArrayList(proIDArray));

		PreparedStatement ps1 = con.prepareStatement("select Pname from packaging_type;");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			proPTypeArray.add(rs1.getString(1));
			proPTypeBox.getItems().add(rs1.getString(1));

			prPaNameItem.addAll(rs1.getString(1));
		}

		proPTypeBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					proPType = proPTypeArray.get(new_val.intValue());
				});

		proPTypeBox = new ChoiceBox<Object>(FXCollections.observableArrayList(proPTypeArray));

		PreparedStatement ps2 = con.prepareStatement("select Mname from measurement_unit;");
		ResultSet rs2 = ps2.executeQuery();

		while (rs2.next()) {

			proMUnitArray.add(rs2.getString(1));
			proMUnitBox.getItems().add(rs2.getString(1));

			prMNameItem.addAll(rs2.getString(1));
		}

		proMUnitBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					proMUnit = proMUnitArray.get(new_val.intValue());
				});

		proMUnitBox = new ChoiceBox<Object>(FXCollections.observableArrayList(proMUnitArray));

		PreparedStatement ps3 = con.prepareStatement("select HID from health_permit;");
		ResultSet rs3 = ps3.executeQuery();

		while (rs3.next()) {

			proHpremitArray.add(rs3.getString(1));
			proHpremitBox.getItems().add(rs3.getString(1));

			prHIDtem.addAll(rs3.getString(1));
		}

		proHpremitBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					proHpremit = proHpremitArray.get(new_val.intValue());
				});

		proHpremitBox = new ChoiceBox<Object>(FXCollections.observableArrayList(proHpremitArray));

		PreparedStatement ps4 = con.prepareStatement("select Bname from brand;");
		ResultSet rs4 = ps4.executeQuery();

		while (rs4.next()) {

			proBrandArray.add(rs4.getString(1));
			proBrandBox.getItems().add(rs4.getString(1));

			bNameItem.addAll(rs4.getString(1));
		}

		proBrandBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					proBrand = proBrandArray.get(new_val.intValue());
				});

		proBrandBox = new ChoiceBox<Object>(FXCollections.observableArrayList(proBrandArray));

		PreparedStatement ps = con.prepareStatement(
				"select p.PrID, p.Pname, b.Bname, p.barcode, p.description, p.size, p.number_of_units, p.HS_code, custom_tax_tariff,\r\n"
						+ "m.Mname, pa.Pname, h.date_of_issue, h.expire_date\r\n"
						+ "from product p, brand b, measurement_unit m, packaging_type pa, health_permit h\r\n"
						+ "where p.Brid = b.bid\r\n" + "and p.MuID = m.MuID\r\n" + "and p.PaID = pa.PaID\r\n"
						+ "and p.HID = h.HID;");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			prIDItem.addAll(rs.getString(1));

			pNameItem.addAll(rs.getString(2));

			prBNameItem.addAll(rs.getString(3));

			prBarcodeItem.addAll(rs.getString(4));

			prDescItem.addAll(rs.getString(5));

			prSizeItem.addAll(rs.getString(6));

			prUnitsItem.addAll(rs.getString(7));

			prHSCodeItem.addAll(rs.getString(8));

			prTaxItem.addAll(rs.getString(9));

			mNameItem.addAll(rs.getString(10));

			paNameItem.addAll(rs.getString(11));

			hIssueItem.addAll(rs.getString(12));

			hExpireItem.addAll(rs.getString(13));
		}
	}

	@FXML
	void productUpdateFunc(ActionEvent event) throws SQLException {
		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID

		String mID = "";
		String paID = "";
		String bID = "";
		String hid = "";

		if (proBrand != "") {

			String SQLtxt = "select BID\r\n" + "from brand\r\n" + "where Bname = '" + proBrand + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			if (rs.next()) {
				bID = rs.getString(1);
			} else {
				errorLabel.setText("Sorry brand name not found...");
			}
		}

		if (proMUnit != "") {

			String SQLtxt = "select MuID\r\n" + "from measurement_unit\r\n" + "where Mname = '" + proMUnit + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			if (rs.next()) {
				mID = rs.getString(1);
			} else {
				errorLabel.setText("Sorry measurement unit not found...");
			}
		}

		if (proPType != "") {

			String SQLtxt = "select PaID\r\n" + "from packaging_type\r\n" + "where Pname = '" + proPType + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			if (rs.next()) {
				paID = rs.getString(1);
			} else {
				errorLabel.setText("Sorry packaging type not found...");
			}
		}

		System.out.println(proHpremit);
		if (proHpremit != "") {

			String SQLtxt = "select HID\r\n" + "from health_permit\r\n" + "where HID = '" + proHpremit + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			if (rs.next()) {
				hid = rs.getString(1);
			} else {
				errorLabel.setText("Sorry health permit not found...");
			}
		}

		productUpdate(proID, productNametxt.getText(), bID, productBarCodetxt.getText(),
				productDescriptiontxt.getText(), productSizetxt.getText(), mID, paID, productNumperOfUnitstxt.getText(),
				hid, productHSCodetxt.getText(), productTaxtxt.getText());
		productSelectFunc(event);

		productNametxt.setText("");
		productBarCodetxt.setText("");
		productDescriptiontxt.setText("");
		productSizetxt.setText("");
		productNumperOfUnitstxt.setText("");
		productHSCodetxt.setText("");
		productTaxtxt.setText("");

		proMUnitBox.getSelectionModel().clearSelection();
		proPTypeBox.getSelectionModel().clearSelection();
		proHpremitBox.getSelectionModel().clearSelection();
		proBrandBox.getSelectionModel().clearSelection();
		proIDBox.getSelectionModel().clearSelection();
	}

///////////////////////////////////////////////////////////////////////////////////// SALES /////////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> saIDListView;

	@FXML
	private ListView<String> saCuIDListView;

	@FXML
	private ListView<String> saPrIDListView;

	@FXML
	private ListView<String> saUnitsListView;

	@FXML
	private ListView<String> saCarTypeListView;

	@FXML
	private ListView<String> saDateListView;

	@FXML
	private ListView<String> saCuNameListView;

	@FXML
	private ListView<String> saPNameListView;

	@FXML
	private TextField salesIDtxt;

	@FXML
	private TextField salesUnitNumtxt;

	@FXML
	private TextField salesCarNumtxt;

	@FXML
	private TextField salesDatetxt;

	@FXML
	private TextField salesSearchtxt;

	@FXML
	ChoiceBox<Object> saleCusBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> saleProBox = new ChoiceBox<Object>();

	ArrayList<String> saleCusArray = new ArrayList<String>();

	ArrayList<String> saleProArray = new ArrayList<String>();

	String saleCusName;
	String saleProName;

	String units = null;
	String description = null;;
	String quantity = null;
	String car = null;
	String date = null;
	String num = null;

	@FXML
	void salesDeleteFunc(ActionEvent event) throws SQLException {

		TableName = "sales";
		TableID = "billID";
		idd = salesIDtxt.getText();

		Delete(idd, TableName, TableID);
		salesSelectFunc(event);

		/*
		 * Statement stmt2 = con.createStatement();
		 * 
		 * String delete = "delete from sales\r\n" + "where billID = '" +
		 * salesIDtxt.getText() + "';";
		 * 
		 * stmt2.executeUpdate(delete); stmt2.close(); salesSelectFunc(event);
		 */

		salesIDtxt.setText("");
		salesUnitNumtxt.setText("");
		salesCarNumtxt.setText("");
		salesDatetxt.setText("");

		saleCusBox.getSelectionModel().clearSelection();
		saleProBox.getSelectionModel().clearSelection();

	}

	@FXML
	void salesInsertFunc(ActionEvent event) throws SQLException, IOException {
		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID

		if (salesDatetxt.getText() != "" && saleProName != "" && saleCusName != "") {

			String SQLtxt = "select CuID\r\n" + "from Customer\r\n" + "where Cname = '" + saleCusName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			String cID = null;
			if (rs1.next()) {
				cID = rs1.getString(1);

				String SQLtxt1 = "select PrID\r\n" + "from product\r\n" + "where Pname = '" + saleProName + "';";

				Statement stmt1 = con.createStatement();
				ResultSet rs = stmt1.executeQuery(SQLtxt1);

				String pID = "";
				if (rs.next()) {
					pID = rs.getString(1);

					String ss = "select CuID, prID\r\n" + "from sales\r\n" + "where prID = '" + pID + "'\r\n"
							+ "and CuID = '" + cID + "'\r\n" + "and saleDate = '" + salesDatetxt.getText() + "';";
					Statement stmt12 = con.createStatement();
					ResultSet rs12 = stmt12.executeQuery(ss);

					if (rs12.next()) {
						errorLabel.setText("This sale is already found ...");
					} else {

						if (salesIDtxt.getText() != "") {

							quantity = salesUnitNumtxt.getText();
							car = salesCarNumtxt.getText();
							date = salesDatetxt.getText();
							num = salesIDtxt.getText();

							// when inserting the Foreign keys, check if they exists in their original table
							Insert = "insert into sales(billID, CuID, prID, number_of_units_soled, CarType, saleDate) "
									+ "VALUES ( '" + salesIDtxt.getText() + "', '" + cID + "', '" + pID + "', '"
									+ salesUnitNumtxt.getText() + "', '" + salesCarNumtxt.getText() + "', '"
									+ salesDatetxt.getText() + "');";

							insert(Insert);
							salesSelectFunc(event);

							if (salesUnitNumtxt.getText() != "") {

								String numOfUnitSoled = salesUnitNumtxt.getText();

								PreparedStatement ps7 = con.prepareStatement("select number_of_units\r\n"
										+ "from product\r\n" + "where PrID = '" + pID + "';");
								ResultSet rs7 = ps7.executeQuery();
								String numOfUnits = null;
								if (rs7.next()) {
									numOfUnits = rs7.getString(1);
								}

								int units = Integer.parseInt(numOfUnits) - Integer.parseInt(numOfUnitSoled);

								String unitUpdate = "update product set number_of_units = '" + units + "'\r\n"
										+ "where PrID = '" + pID + "';";

								Statement stmt11 = con.createStatement();
								stmt11.executeUpdate(unitUpdate);
								stmt11.close();

								salesIDtxt.setText("");
								salesUnitNumtxt.setText("");
								salesCarNumtxt.setText("");
								salesDatetxt.setText("");

								saleCusBox.getSelectionModel().clearSelection();
								saleProBox.getSelectionModel().clearSelection();

								printBill();
							}
						} else {
							errorLabel.setText("Please enter bill ID...");
						}
					}

				} else {
					errorLabel.setText("Sorry product name not found...");
				}

			} else {
				errorLabel.setText("Sorry customer name not found...");
			}

		} else {
			errorLabel.setText("Sorry, an important info is missing...");
		}
	}

	@FXML
	void salesSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> saIDItem = saIDListView.getItems();

		ObservableList<String> saUnitsItem = saUnitsListView.getItems();
		ObservableList<String> saCarItem = saCarTypeListView.getItems();
		ObservableList<String> saDateItem = saDateListView.getItems();

		ObservableList<String> pNameItem = prNameListView.getItems();
		ObservableList<String> prBarcodeItem = prBarcodeListView.getItems();
		ObservableList<String> prDescItem = prDescListView.getItems();
		ObservableList<String> prSizeItem = prSizeListView.getItems();
		ObservableList<String> prUnitsItem = prUnitsListView.getItems();
		ObservableList<String> prHSCodeItem = prHSCodeListView.getItems();
		ObservableList<String> prTaxItem = prtaxListView.getItems();

		ObservableList<String> paNameItem = paNameListView.getItems();
		ObservableList<String> mNameItem = mNameListView.getItems();
		ObservableList<String> hIssueItem = hIssueDateListView.getItems();
		ObservableList<String> hExpireItem = hExpireDateListView.getItems();

		ObservableList<String> cuNameItem = cuNameListView.getItems();
		ObservableList<String> cuAddressItem = cuAddressListView.getItems();
		ObservableList<String> cuNumItem = cuNumListView.getItems();
		ObservableList<String> cuTypeItem = cuTypeListView.getItems();
		ObservableList<String> cuFirstSaleItem = cuFirstSaleListView.getItems();

		ObservableList<String> saCuNameItem = saCuNameListView.getItems();
		ObservableList<String> saPNameItem = saPNameListView.getItems();

		saIDItem.setAll("");
		saCuNameItem.setAll("");
		saPNameItem.setAll("");

		saUnitsItem.setAll("");
		saCarItem.setAll("");
		saDateItem.setAll("");

		pNameItem.setAll("");
		prBarcodeItem.setAll("");
		prDescItem.setAll("");
		prSizeItem.setAll("");
		prUnitsItem.setAll("");
		prHSCodeItem.setAll("");
		prTaxItem.setAll("");

		paNameItem.setAll("");
		mNameItem.setAll("");
		hIssueItem.setAll("");
		hExpireItem.setAll("");

		cuNameItem.setAll("");
		cuAddressItem.setAll("");
		cuTypeItem.setAll("");
		cuNumItem.setAll("");
		cuFirstSaleItem.setAll("");

		saIDItem.remove(0);
		saCuNameItem.remove(0);
		saPNameItem.remove(0);

		saUnitsItem.remove(0);
		saCarItem.remove(0);
		saDateItem.remove(0);

		pNameItem.remove(0);
		prBarcodeItem.remove(0);
		prDescItem.remove(0);
		prSizeItem.remove(0);
		prUnitsItem.remove(0);
		prHSCodeItem.remove(0);
		prTaxItem.remove(0);

		paNameItem.remove(0);
		mNameItem.remove(0);
		hIssueItem.remove(0);
		hExpireItem.remove(0);

		cuNameItem.remove(0);
		cuAddressItem.remove(0);
		cuTypeItem.remove(0);
		cuNumItem.remove(0);
		cuFirstSaleItem.remove(0);

		saleCusArray.clear();
		saleProArray.clear();

		PreparedStatement ps1 = con.prepareStatement("select Cname from Customer;");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			saleCusArray.add(rs1.getString(1));
			saleCusBox.getItems().add(rs1.getString(1));

			saCuNameItem.addAll(rs1.getString(1));
		}

		saleCusBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					saleCusName = saleCusArray.get(new_val.intValue());
				});
		saleCusBox = new ChoiceBox<Object>(FXCollections.observableArrayList(saleCusArray));

		PreparedStatement ps2 = con.prepareStatement("select Pname from product;");
		ResultSet rs2 = ps2.executeQuery();

		while (rs2.next()) {

			saleProArray.add(rs2.getString(1));
			saleProBox.getItems().add(rs2.getString(1));

			saPNameItem.addAll(rs2.getString(1));
		}

		saleProBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					saleProName = saleProArray.get(new_val.intValue());
				});
		saleProBox = new ChoiceBox<Object>(FXCollections.observableArrayList(saleProArray));

		PreparedStatement ps = con.prepareStatement(
				"select s.billID, c.Cname, p.Pname, s.number_of_units_soled, s.saleDate, s.CarType,\r\n"
						+ "c.phone_number, c.Address, c.CuType, c.FirstSaleDate,\r\n"
						+ "p.barcode, p.description, p.size, p.number_of_units, p.HS_code, custom_tax_tariff,\r\n"
						+ "m.Mname, pa.Pname, h.date_of_issue, h.expire_date\r\n"
						+ "from sales s, Customer c, product p, measurement_unit m, packaging_type pa, health_permit h\r\n"
						+ "where c.CuID = s.CuID\r\n" + "and p.PrID = s.prID\r\n" + "and p.MuID = m.MuID\r\n"
						+ "and p.PaID = pa.PaID\r\n" + "and p.HID = h.HID\r\n" + "");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			saIDItem.addAll(rs.getString(1));

			cuNameItem.addAll(rs.getString(2));

			pNameItem.addAll(rs.getString(3));

			saUnitsItem.addAll(rs.getString(4));

			saDateItem.addAll(rs.getString(5));

			saCarItem.addAll(rs.getString(6));

			cuNumItem.addAll(rs.getString(7));

			cuAddressItem.addAll(rs.getString(8));

			cuTypeItem.addAll(rs.getString(9));

			cuFirstSaleItem.addAll(rs.getString(10));

			prBarcodeItem.addAll(rs.getString(11));

			prDescItem.addAll(rs.getString(12));

			prSizeItem.addAll(rs.getString(13));

			prUnitsItem.addAll(rs.getString(14));

			prHSCodeItem.addAll(rs.getString(15));

			prTaxItem.addAll(rs.getString(16));

			mNameItem.addAll(rs.getString(17));

			paNameItem.addAll(rs.getString(18));

			hIssueItem.addAll(rs.getString(19));

			hExpireItem.addAll(rs.getString(20));
		}
		rs.close();
	}

	@FXML
	void salesUpdateFunc(ActionEvent event) throws SQLException {
		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID
		String cID = "";
		String pID = "";

		if (saleCusName != "") {

			String SQLtxt = "select CuID\r\n" + "from Customer\r\n" + "where Cname = '" + saleCusName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				cID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry customer name not found...");
			}
		} else {
			errorLabel.setText("Please enter customer name...");
		}

		if (saleProName != "") {

			String SQLtxt = "select PrID from product\r\n" + "where Pname = '" + saleProName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				pID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry product name not found...");
			}
		} else {
			errorLabel.setText("Please select product name...");
		}

		if (salesIDtxt.getText() != "") {

			salesUpdate(salesIDtxt.getText(), pID, cID, salesUnitNumtxt.getText(), salesCarNumtxt.getText(),
					salesDatetxt.getText());
			salesSelectFunc(event);

			salesIDtxt.setText("");
			salesUnitNumtxt.setText("");
			salesCarNumtxt.setText("");
			salesDatetxt.setText("");

			saleCusBox.getSelectionModel().clearSelection();
			saleProBox.getSelectionModel().clearSelection();
		}
	}

	@FXML
	void salesSearchFunc(ActionEvent event) throws SQLException, IOException {

		String cID = "";
		if (saleCusName != "") {

			String SQLtxt = "select CuID\r\n" + "from Customer\r\n" + "where Cname = '" + saleCusName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				cID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry customer name not found...");
			}
		} else {
			errorLabel.setText("Please enter customer name...");
		}

		ObservableList<String> saIDItem = saIDListView.getItems();

		ObservableList<String> saUnitsItem = saUnitsListView.getItems();
		ObservableList<String> saCarItem = saCarTypeListView.getItems();
		ObservableList<String> saDateItem = saDateListView.getItems();

		ObservableList<String> pNameItem = prNameListView.getItems();
		ObservableList<String> prBarcodeItem = prBarcodeListView.getItems();
		ObservableList<String> prDescItem = prDescListView.getItems();
		ObservableList<String> prSizeItem = prSizeListView.getItems();
		ObservableList<String> prUnitsItem = prUnitsListView.getItems();
		ObservableList<String> prHSCodeItem = prHSCodeListView.getItems();
		ObservableList<String> prTaxItem = prtaxListView.getItems();

		ObservableList<String> paNameItem = paNameListView.getItems();
		ObservableList<String> mNameItem = mNameListView.getItems();
		ObservableList<String> hIssueItem = hIssueDateListView.getItems();
		ObservableList<String> hExpireItem = hExpireDateListView.getItems();

		ObservableList<String> cuNameItem = cuNameListView.getItems();
		ObservableList<String> cuAddressItem = cuAddressListView.getItems();
		ObservableList<String> cuNumItem = cuNumListView.getItems();
		ObservableList<String> cuTypeItem = cuTypeListView.getItems();
		ObservableList<String> cuFirstSaleItem = cuFirstSaleListView.getItems();

		ObservableList<String> saCuNameItem = saCuNameListView.getItems();
		ObservableList<String> saPNameItem = saPNameListView.getItems();

		saIDItem.setAll("");
		saCuNameItem.setAll("");
		saPNameItem.setAll("");

		saUnitsItem.setAll("");
		saCarItem.setAll("");
		saDateItem.setAll("");

		pNameItem.setAll("");
		prBarcodeItem.setAll("");
		prDescItem.setAll("");
		prSizeItem.setAll("");
		prUnitsItem.setAll("");
		prHSCodeItem.setAll("");
		prTaxItem.setAll("");

		paNameItem.setAll("");
		mNameItem.setAll("");
		hIssueItem.setAll("");
		hExpireItem.setAll("");

		cuNameItem.setAll("");
		cuAddressItem.setAll("");
		cuTypeItem.setAll("");
		cuNumItem.setAll("");
		cuFirstSaleItem.setAll("");

		saIDItem.remove(0);
		saCuNameItem.remove(0);
		saPNameItem.remove(0);

		saUnitsItem.remove(0);
		saCarItem.remove(0);
		saDateItem.remove(0);

		pNameItem.remove(0);
		prBarcodeItem.remove(0);
		prDescItem.remove(0);
		prSizeItem.remove(0);
		prUnitsItem.remove(0);
		prHSCodeItem.remove(0);
		prTaxItem.remove(0);

		paNameItem.remove(0);
		mNameItem.remove(0);
		hIssueItem.remove(0);
		hExpireItem.remove(0);

		cuNameItem.remove(0);
		cuAddressItem.remove(0);
		cuTypeItem.remove(0);
		cuNumItem.remove(0);
		cuFirstSaleItem.remove(0);

		saleCusArray.clear();
		saleProArray.clear();

		PreparedStatement ps1 = con.prepareStatement("select Cname from Customer;");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			saleCusArray.add(rs1.getString(1));
			saleCusBox.getItems().add(rs1.getString(1));

			saCuNameItem.addAll(rs1.getString(1));
		}

		saleCusBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					saleCusName = saleCusArray.get(new_val.intValue());
				});
		saleCusBox = new ChoiceBox<Object>(FXCollections.observableArrayList(saleCusArray));

		PreparedStatement ps2 = con.prepareStatement("select Pname from product;");
		ResultSet rs2 = ps2.executeQuery();

		while (rs2.next()) {

			saleProArray.add(rs2.getString(1));
			saleProBox.getItems().add(rs2.getString(1));

			saPNameItem.addAll(rs2.getString(1));
		}

		saleProBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					saleProName = saleProArray.get(new_val.intValue());
				});
		saleProBox = new ChoiceBox<Object>(FXCollections.observableArrayList(saleProArray));

		PreparedStatement ps = con.prepareStatement(
				"select s.billID, c.Cname, p.Pname, s.number_of_units_soled, s.saleDate, s.CarType,\r\n"
						+ "c.phone_number, c.Address, c.CuType, c.FirstSaleDate,\r\n"
						+ "p.barcode, p.description, p.size, p.number_of_units, p.HS_code, custom_tax_tariff,\r\n"
						+ "m.Mname, pa.Pname, h.date_of_issue, h.expire_date\r\n"
						+ "from sales s, Customer c, product p, measurement_unit m, packaging_type pa, health_permit h\r\n"
						+ "where c.CuID = s.CuID\r\n" + "and p.PrID = s.prID\r\n" + "and p.MuID = m.MuID\r\n"
						+ "and p.PaID = pa.PaID\r\n" + "and p.HID = h.HID\r\n" + "and s.CuID = '" + cID + "';\r\n");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			saIDItem.addAll(rs.getString(1));

			cuNameItem.addAll(rs.getString(2));

			pNameItem.addAll(rs.getString(3));

			saUnitsItem.addAll(rs.getString(4));

			saDateItem.addAll(rs.getString(5));

			saCarItem.addAll(rs.getString(6));

			cuNumItem.addAll(rs.getString(7));

			cuAddressItem.addAll(rs.getString(8));

			cuTypeItem.addAll(rs.getString(9));

			cuFirstSaleItem.addAll(rs.getString(10));

			prBarcodeItem.addAll(rs.getString(11));

			prDescItem.addAll(rs.getString(12));

			prSizeItem.addAll(rs.getString(13));

			prUnitsItem.addAll(rs.getString(14));

			prHSCodeItem.addAll(rs.getString(15));

			prTaxItem.addAll(rs.getString(16));

			mNameItem.addAll(rs.getString(17));

			paNameItem.addAll(rs.getString(18));

			hIssueItem.addAll(rs.getString(19));

			hExpireItem.addAll(rs.getString(20));
		}
		rs.close();

	}

///////////////////////////////////////////////////////////////////////////////////// Batch content /////////////////////////////////////////////////////////////////////////////////////

	@FXML
	private ListView<String> bcBaIDListView;

	@FXML
	private ListView<String> bcPrIDListView;

	@FXML
	private ListView<String> bcUnitsListView;

	@FXML
	private ListView<String> bcProdDateListView;

	@FXML
	private ListView<String> bcExpireDateListView;

	@FXML
	private ListView<String> bcProductNameListView;

	@FXML
	private ListView<String> bcBatchNameListView;

	@FXML
	private TextField batchConUnitsNumtxt;

	@FXML
	private TextField batchConProducDatetxt;

	@FXML
	private TextField batchConExpireDatetxt;

	@FXML
	ChoiceBox<Object> BcBatchBox = new ChoiceBox<Object>();

	@FXML
	ChoiceBox<Object> BcProBox = new ChoiceBox<Object>();

	ArrayList<String> BcBatchArray = new ArrayList<String>();

	ArrayList<String> BcProArray = new ArrayList<String>();

	String BCBatchID;
	String BCProName;

	@FXML
	void batchContentDeleteFunc(ActionEvent event) throws SQLException {

		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID

		String SQLtxt1 = "select PrID\r\n" + "from product\r\n" + "where Pname = '" + BCProName + "';";

		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(SQLtxt1);

		String pID = "";
		if (rs1.next()) {
			pID = rs1.getString(1);

			String SQLtxt = "select Baid\r\n" + "from Batch\r\n" + "where Baid = '" + BCBatchID + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			String bID = "";
			if (rs.next()) {
				bID = rs.getString(1);

				Statement stmt2 = con.createStatement();

				String delete = "delete from batch_content\r\n" + "where prID = '" + pID + "'\r\n" + "and baid = '"
						+ bID + "';";

				stmt2.executeUpdate(delete);
				stmt2.close();

				batchContentSelectFunc(event);

				batchConUnitsNumtxt.setText("");
				batchConProducDatetxt.setText("");
				batchConExpireDatetxt.setText("");

				BcBatchBox.getSelectionModel().clearSelection();
				BcProBox.getSelectionModel().clearSelection();

			} else {
				errorLabel.setText("Sorry batch id not found...");
			}

		} else {
			errorLabel.setText("Sorry product name not found...");
		}
	}

	@FXML
	void batchContentInsertFunc(ActionEvent event) throws SQLException {
		// READ THE NAME OF THE FORIEGN KEY THEN GET ITS ID

		String SQLtxt1 = "select PrID\r\n" + "from product\r\n" + "where Pname = '" + BCProName + "';";

		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(SQLtxt1);

		String pID = "";
		if (rs1.next()) {
			pID = rs1.getString(1);

			String SQLtxt = "select Baid\r\n" + "from Batch\r\n" + "where Baid = '" + BCBatchID + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQLtxt);

			String bID = "";
			if (rs.next()) {
				bID = rs.getString(1);

				String ss = "select baid, prID\r\n" + "from batch_content\r\n" + "where baid = '" + bID + "'\r\n"
						+ "and prID = '" + pID + "';";
				Statement stmt12 = con.createStatement();
				ResultSet rs12 = stmt12.executeQuery(ss);

				if (rs12.next()) {
					errorLabel.setText("This content is already found ...");
				} else {

					Insert = "insert into batch_content(baid, prID, number_of_units, production_date, expiry_date) "
							+ "VALUES ( '" + bID + "', '" + pID + "', '" + batchConUnitsNumtxt.getText() + "', '"
							+ batchConProducDatetxt.getText() + "', '" + batchConExpireDatetxt.getText() + "');";

					insert(Insert);

					if (batchConUnitsNumtxt.getText() != "") {

						String numOfNewUnits = batchConUnitsNumtxt.getText();

						PreparedStatement ps7 = con.prepareStatement(
								"select number_of_units\r\n" + "from product\r\n" + "where PrID = '" + pID + "';");
						ResultSet rs7 = ps7.executeQuery();
						String numOfUnits = null;
						if (rs7.next()) {
							numOfUnits = rs7.getString(1);
						}

						int units = Integer.parseInt(numOfUnits) + Integer.parseInt(numOfNewUnits);

						String unitUpdate = "update product set number_of_units = '" + units + "'\r\n"
								+ "where PrID = '" + pID + "';";

						Statement stmt11 = con.createStatement();
						stmt11.executeUpdate(unitUpdate);
						stmt11.close();

						batchContentSelectFunc(event);

						batchConUnitsNumtxt.setText("");
						batchConProducDatetxt.setText("");
						batchConExpireDatetxt.setText("");

						BcBatchBox.getSelectionModel().clearSelection();
						BcProBox.getSelectionModel().clearSelection();
					}

				}
			} else {
				errorLabel.setText("Sorry batch id not found...");
			}

		} else {
			errorLabel.setText("Sorry product name not found...");
		}
	}

	@FXML
	void batchContentSelectFunc(ActionEvent event) throws SQLException {

		ObservableList<String> bcProdDateItem = bcProdDateListView.getItems();
		ObservableList<String> bcExpDateItem = bcExpireDateListView.getItems();
		ObservableList<String> bcUnitsItem = bcUnitsListView.getItems();
		ObservableList<String> bcIDItem = bcBaIDListView.getItems();

		ObservableList<String> pNameItem = prNameListView.getItems();
		ObservableList<String> prBarcodeItem = prBarcodeListView.getItems();
		ObservableList<String> prDescItem = prDescListView.getItems();
		ObservableList<String> prSizeItem = prSizeListView.getItems();
		ObservableList<String> prHSCodeItem = prHSCodeListView.getItems();
		ObservableList<String> prTaxItem = prtaxListView.getItems();
		ObservableList<String> paNameItem = paNameListView.getItems();
		ObservableList<String> mNameItem = mNameListView.getItems();
		ObservableList<String> hIssueItem = hIssueDateListView.getItems();
		ObservableList<String> hExpireItem = hExpireDateListView.getItems();

		ObservableList<String> baArrivalItem = baArrivaleListView.getItems();
		ObservableList<String> cnameItem = cnameListView.getItems();

		ObservableList<String> bcProductName = bcProductNameListView.getItems();
		ObservableList<String> bcBatchName = bcBatchNameListView.getItems();

		bcProdDateItem.setAll("");
		bcExpDateItem.setAll("");
		bcUnitsItem.setAll("");
		bcIDItem.setAll("");

		pNameItem.setAll("");
		prBarcodeItem.setAll("");
		prDescItem.setAll("");
		prSizeItem.setAll("");
		prHSCodeItem.setAll("");
		prTaxItem.setAll("");
		paNameItem.setAll("");
		mNameItem.setAll("");
		hIssueItem.setAll("");
		hExpireItem.setAll("");

		baArrivalItem.setAll("");
		cnameItem.setAll("");

		bcProductName.setAll("");
		bcBatchName.setAll("");

		bcProdDateItem.remove(0);
		bcExpDateItem.remove(0);
		bcUnitsItem.remove(0);
		bcIDItem.remove(0);

		pNameItem.remove(0);
		prBarcodeItem.remove(0);
		prDescItem.remove(0);
		prSizeItem.remove(0);
		prHSCodeItem.remove(0);
		prTaxItem.remove(0);
		paNameItem.remove(0);
		mNameItem.remove(0);
		hIssueItem.remove(0);
		hExpireItem.remove(0);

		baArrivalItem.remove(0);
		cnameItem.remove(0);

		bcProductName.remove(0);
		bcBatchName.remove(0);

		BcBatchArray.clear();
		BcProArray.clear();

		PreparedStatement ps3 = con.prepareStatement("select Baid from Batch;");
		ResultSet rs3 = ps3.executeQuery();

		while (rs3.next()) {

			BcBatchArray.add(rs3.getString(1));
			BcBatchBox.getItems().add(rs3.getString(1));

			bcBatchName.addAll(rs3.getString(1));
		}

		BcBatchBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					BCBatchID = BcBatchArray.get(new_val.intValue());
				});

		BcBatchBox = new ChoiceBox<Object>(FXCollections.observableArrayList(BcBatchArray));

		PreparedStatement ps2 = con.prepareStatement("select Pname from product;");
		ResultSet rs2 = ps2.executeQuery();

		while (rs2.next()) {

			BcProArray.add(rs2.getString(1));
			BcProBox.getItems().add(rs2.getString(1));

			bcProductName.addAll(rs2.getString(1));
		}

		BcProBox.getSelectionModel().selectedIndexProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

					BCProName = BcProArray.get(new_val.intValue());
				});

		BcProBox = new ChoiceBox<Object>(FXCollections.observableArrayList(BcProArray));

		PreparedStatement ps1 = con.prepareStatement("select p.Pname, b.baid, c.Coname,\r\n"
				+ "b.arrival_date, bc.number_of_units, bc.production_date, bc.expiry_date,\r\n"
				+ "p.barcode, p.description, p.size,\r\n" + "p.HS_code, p.custom_tax_tariff,\r\n"
				+ "m.Mname, pa.Pname, h.date_of_issue, h.expire_date\r\n"
				+ "from batch_content bc, Batch b, company c, shipping_company s,\r\n"
				+ "product p, measurement_unit m, packaging_type pa, health_permit h\r\n" + "where bc.baid = b.Baid\r\n"
				+ "and bc.prID = p.PrID\r\n" + "and p.MuID = m.MuID\r\n" + "and p.PaID = pa.PaID\r\n"
				+ "and p.HID = h.HID\r\n" + "and b.CoID = c.CoID\r\n" + "and b.SID = s.SID;");

		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {

			pNameItem.addAll(rs1.getString(1));

			bcIDItem.addAll(rs1.getString(2));

			cnameItem.addAll(rs1.getString(3));

			baArrivalItem.addAll(rs1.getString(4));

			bcUnitsItem.addAll(rs1.getString(5));

			bcProdDateItem.addAll(rs1.getString(6));

			bcExpDateItem.addAll(rs1.getString(7));

			prBarcodeItem.addAll(rs1.getString(8));

			prDescItem.addAll(rs1.getString(9));

			prSizeItem.addAll(rs1.getString(10));

			prHSCodeItem.addAll(rs1.getString(11));

			prTaxItem.addAll(rs1.getString(12));

			mNameItem.addAll(rs1.getString(13));

			paNameItem.addAll(rs1.getString(14));

			hIssueItem.addAll(rs1.getString(15));

			hExpireItem.addAll(rs1.getString(16));
		}
	}

	@FXML
	void batchContentUpdateFunc(ActionEvent event) throws SQLException {

		String bID = "";
		String pID = "";

		if (BCBatchID != "") {

			String SQLtxt = "select Baid\r\n" + "from Batch\r\n" + "where Baid = '" + BCBatchID + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				bID = rs1.getString(1);

			} else {
				errorLabel.setText("Sorry batch id not found...");
			}
		}

		if (BCProName != "") {

			String SQLtxt = "select PrID\r\n" + "from product\r\n" + "where Pname = '" + BCProName + "';";

			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(SQLtxt);

			if (rs1.next()) {
				pID = rs1.getString(1);
			} else {
				errorLabel.setText("Sorry product name not found...");
			}
		}

		batchContentUpdate(pID, bID, batchConUnitsNumtxt.getText(), batchConProducDatetxt.getText(),
				batchConExpireDatetxt.getText());

		batchContentSelectFunc(event);

		batchConUnitsNumtxt.setText("");
		batchConProducDatetxt.setText("");
		batchConExpireDatetxt.setText("");

		BcBatchBox.getSelectionModel().clearSelection();
		BcProBox.getSelectionModel().clearSelection();
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////// INSERT /////////////////////////////////////////////////////////////////////////////////////

	static void insert(String Insert) throws SQLException {

		Statement stmt = con.createStatement();
		stmt.executeUpdate(Insert);
	}

////////////////////////////////////////////////////////////////////////////////////// DELETE /////////////////////////////////////////////////////////////////////////////////////

	static void Delete(String ID, String tableName, String tableID) throws SQLException {

		Statement stmt = con.createStatement();
		String delete = "delete from " + tableName + " where " + tableID + " ='" + ID + "';";

		stmt.executeUpdate(delete);
		stmt.close();
	}

////////////////////////////////////////////////////////////////////////////////////// UPDATE /////////////////////////////////////////////////////////////////////////////////////

	static void CompanyUpdate(String idu, String nameu, String countryu, String cityu, String addressu, String contactu,
			String emailu, String phone_numberu) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update company set Coname = '" + nameu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (countryu != "") {

			update = "update company set country = '" + countryu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (cityu != "") {

			update = "update company set city = '" + cityu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (addressu != "") {

			update = "update company set address = '" + addressu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (contactu != "") {

			update = "update company set Ccontact_person = '" + contactu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (emailu != "") {

			update = "update company set email = '" + emailu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (phone_numberu != "") {

			update = "update company set phone_number = '" + phone_numberu + "' where CoID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void ShippingCompanyUpdate(String idu, String nameu, String countryu, String phone_numberu, String emailu,
			String contactu) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update shipping_company set SCname = '" + nameu + "' where SID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (countryu != "") {

			update = "update shipping_company set country = '" + countryu + "' where SID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (contactu != "") {

			update = "update shipping_company set SCcontact_person = '" + contactu + "' where SID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (phone_numberu != "") {

			update = "update shipping_company set phone_number = '" + emailu + "' where SID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (emailu != "") {

			update = "update shipping_company set email = '" + phone_numberu + "' where SID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void BatchUpdate(String idu, String cidu1, String sidu2, String sizeu, String brokeru, String adateu)
			throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (cidu1 != "") {

			update = "update Batch set CoID = '" + cidu1 + "' where Baid = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (sidu2 != "") {

			update = "update Batch set SID = '" + sidu2 + "' where Baid = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (sizeu != "") {

			update = "update Batch set size = '" + sizeu + "' where Baid = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (brokeru != "") {

			update = "update Batch set customer_broker = '" + brokeru + "' where Baid = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (adateu != "") {

			update = "update Batch set arrival_date = '" + adateu + "' where Baid = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void CustomerUpdate(String idu, String nameu, String phoneu, String address, String type, String SaleDate)
			throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update Customer set Cname = '" + nameu + "' where CuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (phoneu != "") {

			update = "update Customer set phone_number = '" + phoneu + "' where CuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (address != "") {

			update = "update Customer set Address = '" + address + "' where CuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (type != "") {

			update = "update Customer set CuType = '" + type + "' where CuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (SaleDate != "") {

			update = "update Customer set FirstSaleDate = '" + SaleDate + "' where CuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void brandUpdate(String idu, String cidu1, String nameu) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update brand set Bname = '" + nameu + "' where BID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (cidu1 != "") {

			update = "update brand set CoID = '" + cidu1 + "' where BID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void healthPermitUpdate(String idu, String issue, String expireDate) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (issue != "") {

			update = "update health_permit set date_of_issue = '" + issue + "' where HID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (expireDate != "") {

			update = "update health_permit set expire_date = '" + expireDate + "' where HID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void measurementUnitUpdate(String idu, String nameu) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update measurement_unit set Mname = '" + nameu + "' where MuID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void packagingTypeUpdate(String idu, String nameu) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (nameu != "") {

			update = "update packaging_type set Pname = '" + nameu + "' where PaID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void productUpdate(String idu, String name, String BrID, String barCode, String description, String size,
			String MuID, String PaID, String numUnits, String HID, String HSCode, String tax) throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (BrID != "") {

			update = "update product set BrID = '" + BrID + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (name != "") {

			update = "update product set Pname = '" + name + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (barCode != "") {

			update = "update product set barcode = '" + barCode + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (description != "") {

			update = "update product set description = '" + description + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (size != "") {

			update = "update product set size = '" + size + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (MuID != "") {

			update = "update product set MuID = '" + MuID + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (PaID != "") {

			update = "update product set PaID = '" + PaID + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (numUnits != "") {

			update = "update product set number_of_units = '" + numUnits + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (HID != "") {

			update = "update product set HID = '" + HID + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (HSCode != "") {

			update = "update product set HS_code = '" + HSCode + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (tax != "") {

			update = "update product set custom_tax_tariff = '" + tax + "' where PrID = '" + idu + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void salesUpdate(String sID, String pID, String cID, String unit, String car, String saleDate)
			throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (unit != "") {

			update = "update sales set number_of_units_soled = '" + unit + "' where billID = '" + sID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (pID != "") {

			update = "update sales set prID = '" + pID + "' where billID = '" + sID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (cID != "") {

			update = "update sales set CuID = '" + cID + "' where billID = '" + sID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (car != "") {

			update = "update sales set CarType = '" + car + "' where billID = '" + sID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (saleDate != "") {

			update = "update sales set saleDate = '" + saleDate + "' where billID = '" + sID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

	static void batchContentUpdate(String pID, String bID, String unit, String pDate, String eDate)
			throws SQLException {

		Statement stmt = con.createStatement();

		String update;

		if (unit != "") {

			update = "update batch_content set number_of_units = '" + unit + "' where prID = '" + pID + "' and baid = '"
					+ bID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (pDate != "") {

			update = "update batch_content set production_date = '" + pDate + "' where prID = '" + pID
					+ "' and baid = '" + bID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		else if (eDate != "") {

			update = "update batch_content set expiry_date = '" + eDate + "' where prID = '" + pID + "' and baid = '"
					+ bID + "';";
			stmt = con.createStatement();
			stmt.executeUpdate(update);

		}

		stmt.close();

	}

///////////////////////////////////////////////////////////////////////////////////// MAIN //////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		DBConn a = new DBConn(URL, port, dbName, dbUsername, dbPassword);
		con = a.connectDB();

		String SQLtxt = "use Project;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQLtxt);

		rs.close();
		stmt.close();
		String window;

		try {

			window = "windows/main.fxml";

			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(window));

			Scene scene = new Scene(root);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


class DBConn {

	private Connection con;
	private String dbURL;
	private String dbUsername;
	private String dbPassword;
	private String URL;
	private String port;
	private String dbName;

	DBConn(String URL, String port, String dbName, String dbUsername, String dbPassword) {

		this.URL = URL;
		this.port = port;
		this.dbName = dbName;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	public Connection connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";

		System.out.println(dbURL);

		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, p);

		System.out.println("Connection established");
		return con;
	}
}