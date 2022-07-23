package potatoxf.helper.module.workflow.idm;

import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.rest.idm.CurrentUserProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author potatoxf
 * @date 2022/7/2
 */
@Component
public class AdminCurrentUserProvider implements CurrentUserProvider {
  @Override
  public UserRepresentation getCurrentUser(Authentication authentication) {
    UserRepresentation userRepresentation = new UserRepresentation();
    userRepresentation.setFirstName("ADMIN");
    userRepresentation.setLastName("ADMIN");
    userRepresentation.setFullName("ADMIN");
    userRepresentation.setId("ADMIN");
    userRepresentation.setPrivileges(
        Arrays.asList(
            "flowable-idm",
            "flowable-admin",
            "flowable-modeler",
            "flowable-task",
            "flowable-rest"));
    return userRepresentation;
  }

  @Override
  public boolean supports(Authentication authentication) {
    return true;
  }
}
