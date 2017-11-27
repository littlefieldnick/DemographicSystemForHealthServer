package edu.usm.cos375;

import edu.usm.cos375.filter.CORSFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[] { WebConfig.class };
        return new Class[] { RestConfig.class };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return null;
    }

    @Override
    protected Filter[] getServletFilters()
    {
        return new Filter[] { new CORSFilter() };
    }
}