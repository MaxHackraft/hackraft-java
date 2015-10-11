package net.hackraft.api.config;

import dao.action.ActionDataImpl;
import dao.action.IActionData;
import dao.user.UserDataImpl;
import data.Connector;
import net.hackraft.core.domain.action.ActionDomain;
import net.hackraft.core.domain.action.IAction;
import net.hackraft.core.domain.user.IUser;
import net.hackraft.core.domain.user.UserDomainImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * Guice Bridge config.
 *
 * @author Maxim Kheilik
 */
public class BridgeConfig extends AbstractBinder {

    @Override
    protected void configure() {
        bind(ActionDomain.class).to(IAction.class);
        bind(UserDomainImpl.class).to(IUser.class);

        bind(ActionDataImpl.class).to(IActionData.class);
        bind(UserDataImpl.class).to(IUser.class);

        bind(Connector.class).to(Connector.class).in(Singleton.class);
    }
}
