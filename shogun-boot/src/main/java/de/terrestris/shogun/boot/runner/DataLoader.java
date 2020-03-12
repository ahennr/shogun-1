package de.terrestris.shogun.boot.runner;

import de.terrestris.shogun.lib.enumeration.PermissionCollectionType;
import de.terrestris.shogun.lib.enumeration.PermissionType;
import de.terrestris.shogun.lib.model.Application;
import de.terrestris.shogun.lib.model.Group;
import de.terrestris.shogun.lib.model.User;
import de.terrestris.shogun.lib.model.security.permission.GroupInstancePermission;
import de.terrestris.shogun.lib.model.security.permission.PermissionCollection;
import de.terrestris.shogun.lib.repository.ApplicationRepository;
import de.terrestris.shogun.lib.repository.GroupRepository;
import de.terrestris.shogun.lib.repository.UserRepository;
import de.terrestris.shogun.lib.repository.security.permission.GroupInstancePermissionRepository;
import de.terrestris.shogun.lib.repository.security.permission.PermissionCollectionRepository;
import de.terrestris.shogun.lib.repository.security.permission.UserInstancePermissionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataLoader implements ApplicationRunner {

    protected final Logger LOG = LogManager.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private PermissionCollectionRepository permissionCollectionRepository;

    @Autowired
    private GroupInstancePermissionRepository groupInstancePermissionRepository;

    @Autowired
    private UserInstancePermissionRepository userInstancePermissionRepository;

    public void run(ApplicationArguments args) {
        LOG.info("Initializing the application");

        User peter = new User("12a56987-36f3-4bc0-93bd-3b7c0ff7d726", null, null);
        userRepository.save(peter);

        Application testApp = new Application();
        testApp.setName("Test Applikation");
        applicationRepository.save(testApp);

        Group g = new Group("f1131858-bb78-4502-94e2-fd29b0ca0d85");
        groupRepository.save(g);

        GroupInstancePermission gip = new GroupInstancePermission(g);
        gip.setEntity(testApp);

        PermissionCollection pc = new PermissionCollection();
        HashSet<PermissionType> permType = new HashSet<>();
        permType.add(PermissionType.READ);
        pc.setName(PermissionCollectionType.READ);
        pc.setPermissions(permType);
        permissionCollectionRepository.save(pc);

        gip.setPermissions(pc);
        groupInstancePermissionRepository.save(gip);
    }
}
