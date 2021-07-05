package context;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.CommentModel;
import model.ReferenceModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceContext{
    private Connection connection;

    public ReferenceContext() throws SQLServerException {
        connection = ConnectionString.init();
    }

    public List<ReferenceModel> getReferences(String filter) throws SQLException {
        PreparedStatement statement;
        if(filter!=null)
            statement= connection.prepareStatement("select * from WSREF where description like ".concat("'%")+filter.concat("%'"));
        else
            statement=connection.prepareStatement("select * from WSREF");

        ResultSet result = statement.executeQuery();
        List<ReferenceModel> referenceModels = new ArrayList<>();
        while (result.next()) {
            referenceModels.add(new ReferenceModel(result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5)));
        }
        return referenceModels;
    }

    public void addReferences(ReferenceModel referenceModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into WSREF(url,description,minus,plus) values(?,?,?,?)");
        statement.setString(1, referenceModel.getUrl());
        statement.setString(2, referenceModel.getDescription());
        statement.setInt(3, referenceModel.getMinus());
        statement.setInt(4, referenceModel.getPlus());
        statement.executeUpdate();
    }

    public void updateReferences(ReferenceModel referenceModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update WSREF set description=".concat("'")
                + referenceModel.getDescription().concat("'")+",plus="+referenceModel.getPlus()+",minus="+referenceModel.getMinus()+
                " where id="+ referenceModel.getId());
        statement.executeUpdate();
    }

    public void deleteReference(ReferenceModel referenceModel) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("delete from WSREFCOMMENT where wsref_id="+ referenceModel.getId());
        statement.executeUpdate();
        statement=connection.prepareStatement("delete from WSREF where id="+ referenceModel.getId());
        statement.executeUpdate();
    }
}
