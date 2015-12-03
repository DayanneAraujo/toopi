# -*- coding: utf-8 -*-

"""
Django settings for harpia project.

Generated by 'django-admin startproject' using Django 1.8.

For more information on this file, see
https://docs.djangoproject.com/en/1.8/topics/settings/

For the full list of settings and their values, see
https://docs.djangoproject.com/en/1.8/ref/settings/
"""

from decouple import config
from dj_database_url import parse as db_url
from os.path import join
from sys import path
from unipath import Path
import os

BASE_DIR = Path(__file__).absolute().ancestor(2)
APPS_DIR = BASE_DIR.child('apps')
path.insert(0, APPS_DIR)

SECRET_KEY = config('SECRET_KEY')

DEBUG = config('DEBUG', default=False, cast=bool)

DEMO = config('DEMO', default=False, cast=bool)

PROJECT_NAME = 'harpia'

ALLOWED_HOSTS = [
    '*',
]

SECURE_PROXY_SSL_HEADER = ('HTTP_X_FORWARDED_PROTO', 'https')

# Application definition

DJANGO_APPS = (
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
)

LOCAL_APPS = (
    'licitacao',
)

THIRD_PARTY_APPS = (
    'bootstrap3',
    'django_filters',
    'djangobower',
    'djangoformsetjs',
    'formtools',
    'gunicorn',
    'localflavor',
    'model_mommy',
    'raven.contrib.django.raven_compat',
    'rest_framework',
    'storages',
    'taggit',
    'widget_tweaks',
)

INSTALLED_APPS = DJANGO_APPS + LOCAL_APPS + THIRD_PARTY_APPS

ROOT_URLCONF = 'harpia.urls'

MIDDLEWARE_CLASSES = (
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.auth.middleware.SessionAuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
    'django.middleware.security.SecurityMiddleware',
)

TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]

WSGI_APPLICATION = 'harpia.wsgi.application'

# Database
# https://docs.djangoproject.com/en/1.8/ref/settings/#databases

DATABASES = {
    'default': config(
        'DATABASE_URL',
        default='sqlite:///{0}/{1}'.format(
            BASE_DIR.child('db'),
            'harpia.sqlite3'),
        cast=db_url),
}

FIXTURE_DIRS = (join(BASE_DIR.child('db'), 'fixtures'), )

# Internationalization
# https://docs.djangoproject.com/en/1.8/topics/i18n/

LANGUAGE_CODE = 'pt-br'

LANGUAGES = (
    ('pt-br', 'Português'),
)

TIME_ZONE = 'UTC'

USE_I18N = True

USE_L10N = True

USE_TZ = True


# Static files (CSS, JavaScript, Images)
# https://docs.djangoproject.com/en/1.8/howto/static-files/

STATIC_ROOT = 'staticfiles'
STATIC_URL = '/static/'

STATICFILES_DIRS = (
    os.path.join(BASE_DIR, 'static/'),
)

STATICFILES_FINDERS = (
    'django.contrib.staticfiles.finders.FileSystemFinder',
    'django.contrib.staticfiles.finders.AppDirectoriesFinder',
    'djangobower.finders.BowerFinder'
)

BOWER_COMPONENTS_ROOT = config('BOWER_COMPONENTS_ROOT',
                               default=BASE_DIR.ancestor(1).child('vendor'))
