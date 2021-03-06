package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;

/**
 * A simple helloworld example for Apache Ignite
 * @author Gaurav Rai Mazra
 * {@link https://lineofcode.in}
 *
 */
public class HelloworldIgniteExample {	
	public static void main(String[] args) {
		try (Ignite ignite =  Ignition.start(defaultIgniteCfg("hello-world"))) {
			IgniteRunnable task = new IgniteRunnable() {
				private static final long serialVersionUID = 787726700536869271L;

				@IgniteInstanceResource
				private transient Ignite ignite;
				@Override
				public void run() {
					System.out.println("Hello Gaurav Bytes from: " + ignite.name());
					
				}
			};
			ignite.compute().run(task);
		}
		Ignition.stop(true);
	}
}
