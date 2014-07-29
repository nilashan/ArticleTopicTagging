package org.wso2.service;

import org.wso2.beans.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/Tagger/")
public interface Tagger {

    //login
    @PermitAll
    @POST
    @Path("/loginUser/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> loginUser(@HeaderParam("Authorization") String username) throws SQLException;

	//for user
    @PermitAll
	@POST
	@Path("/addUser/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@PUT
	@Path("/updateUser/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getUser/")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUser() throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getUser/{email}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUser(@PathParam("email") String email) throws SQLException;

    @RolesAllowed("ADMIN")
	@DELETE
	@Path("/deleteUser/{email}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("email") String email) throws SQLException;
	
	//for article
    @RolesAllowed({"ADMIN","USER"})
	@POST
	@Path("/addArticle/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addArticle(Article article) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@PUT
	@Path("/updateArticle/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateArticle(Article article) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getArticle/")
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Article> getArticle() throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getArticle/{article_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Article> getArticle(@PathParam("article_id") int article_id) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@DELETE
	@Path("/deleteArticle/{article_id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteArticle(@PathParam("article_id") int article_id) throws SQLException;
	
	//for role
    @RolesAllowed("ADMIN")
	@POST
	@Path("/addRole/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRole(Role role) throws SQLException;

    @RolesAllowed("ADMIN")
	@PUT
	@Path("/updateRole/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRole(Role role) throws SQLException;

    @RolesAllowed("ADMIN")
	@GET
	@Path("/getRole/")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Role> getRole() throws SQLException;

    @RolesAllowed("ADMIN")
	@GET
	@Path("/getRole/{role_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Role> getRole(@PathParam("role_id") int role_id) throws SQLException;

    @RolesAllowed("ADMIN")
	@DELETE
	@Path("/deleteRole/{role_id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRole(@PathParam("role_id") int role_id) throws SQLException;
	
	//for category
    @RolesAllowed("ADMIN")
	@POST
	@Path("/addCategory/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCategory(Category category) throws SQLException;

    @RolesAllowed("ADMIN")
	@PUT
	@Path("/updateCategory/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(Category category) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getCategory/")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Category> getCategory() throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getCategory/{category_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Category> getCategory(@PathParam("category_id") int category_id) throws SQLException;

    @RolesAllowed("ADMIN")
	@DELETE
	@Path("/deleteCategory/{category_id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCategory(@PathParam("category_id") int category_id) throws SQLException;
	
	//for subcategory
    @RolesAllowed("ADMIN")
	@POST
	@Path("/addSubCategory/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSubCategory(SubCategory sub_category) throws SQLException;

    @RolesAllowed("ADMIN")
	@PUT
	@Path("/updateSubCategory/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSubCategory(SubCategory sub_category) throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getSubCategory/")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SubCategory> getSubCategory() throws SQLException;

    @RolesAllowed({"ADMIN","USER"})
	@GET
	@Path("/getSubCategory/{sub_category_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SubCategory> getSubCategory(@PathParam("sub_category_id") int sub_category_id) throws SQLException;

    @RolesAllowed("ADMIN")
	@DELETE
	@Path("/deleteSubCategory/{sub_category_id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSubCategory(@PathParam("sub_category_id") int sub_category_id) throws SQLException;
}