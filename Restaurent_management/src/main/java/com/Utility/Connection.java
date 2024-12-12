package com.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection{

	public static SessionFactory getSessionFactory() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("Config.xml")
				.build();

		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

		return metadata.getSessionFactoryBuilder().build();
	}
}
