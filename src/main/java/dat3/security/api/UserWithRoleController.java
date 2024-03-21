package dat3.security.api;

import dat3.security.dto.UserWithRolesRequest;
import dat3.security.dto.UserWithRolesResponse;
import dat3.security.service.UserWithRolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user-with-role")
public class UserWithRoleController {

  UserWithRolesService userWithRolesService;

  public UserWithRoleController(UserWithRolesService userWithRolesService) {
    this.userWithRolesService = userWithRolesService;
  }
//Get all users
//@PreAuthorize("hasAuthority('ADMIN')")
@GetMapping("/users")
@Operation(summary = "Get all users with roles", description = "Returns a list of all users with their roles",
    responses = {
                @ApiResponse(responseCode = "200", description = "A list of all users with their roles"),
                @ApiResponse(responseCode = "400", description = "No users found")})
public List<UserWithRolesResponse> getAllUsersWithRoles() {
  return userWithRolesService.getUsersWithRoles();
}
  //Anonymous users can call this.
  @PostMapping
  @Operation(summary = "Add a new UserWithRoles user",
             description = "If a default role is defined (app.default-role ), this role will be assigned to the user.",
       responses = {
                     @ApiResponse(responseCode = "200", description = "A new user has been added"),
                     @ApiResponse(responseCode = "400", description = "Could not add user")})
  public UserWithRolesResponse addUserWithRoles(@RequestBody UserWithRolesRequest request) {
    return userWithRolesService.addUserWithRoles(request);
  }

  //Take care with this. This should NOT be something everyone can call
  //@PreAuthorize("hasAuthority('ADMIN')")
  @PatchMapping("/add-role/{username}/{role}")
  @Operation(summary = "Add a role to a UserWithRoles", description = "Caller must be authenticated with the role ADMIN",
      responses = {
                  @ApiResponse(responseCode = "200", description = "A role has been added"),
                  @ApiResponse(responseCode = "400", description = "Could not add role to user")})
  public UserWithRolesResponse addRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.addRole(username, role);
  }

  //Take care with this. This should NOT be something everyone can call
  @PreAuthorize("hasAuthority('ADMIN')")
  @PatchMapping("/remove-role/{username}/{role}")
  @Operation(summary = "Removes a role from a UserWithRoles", description = "Caller must be authenticated with the role ADMIN",
      responses = {
                  @ApiResponse(responseCode = "200", description = "A role has been removed from user"),
                  @ApiResponse(responseCode = "400", description = "Could not remove role from user")})
  public UserWithRolesResponse removeRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.removeRole(username, role);
  }
}