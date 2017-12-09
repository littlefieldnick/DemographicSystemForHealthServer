package edu.usm.cos375;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.usm.cos375.filter.CORSFilter;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
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
        return null;//new Filter[] { new CORSFilter() };
    }
}