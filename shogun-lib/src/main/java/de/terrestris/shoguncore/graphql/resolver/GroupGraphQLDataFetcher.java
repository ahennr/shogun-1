package de.terrestris.shoguncore.graphql.resolver;

import de.terrestris.shoguncore.model.Group;
import de.terrestris.shoguncore.service.GroupService;
import org.springframework.stereotype.Component;

@Component
public class GroupGraphQLDataFetcher extends BaseGraphQLDataFetcher<Group, GroupService> { }
